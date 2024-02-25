import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, room, squareMax, brokenWallMax;
	static int[][] arr;
	static int[][] roomNum;
	static Map<Integer, Integer> map;
	static int[] di = { 0, -1, 0, 1 }; // 서, 북, 동, 남
	static int[] dj = { -1, 0, 1, 0 };
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		visit = new boolean[N][M];
		roomNum = new int[N][M]; // 방 번호를 저장할 배열

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end input

		room = 0; // 이 성의 있는 방의 개수
		squareMax = -1; // 가장 넓은 방의 넓이
		brokenWallMax = -1; // 하나의 벽을 제거하여 얻을 수 있는 가장 넓은 방의 크기

		int num = 1; // 방 번호
		map = new HashMap<>(); // 방 번호 별 넓이를 저장

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visit[i][j]) {
					bfs(i, j, num);
					room++;
					num++;
				}
			}
		}

		int tmp = 0;

		////// 배열 전체를 돌며 인접한 방의 넓이와 더해보며 벽 제거 후 가장 넓은 크기를 찾음.
		
		// 가로 방향으로 돈다.
		for (int i = 0; i < N; i++) {

			tmp = roomNum[i][0];

			for (int j = 0; j < M; j++) {
				if (tmp != roomNum[i][j]) {
					brokenWallMax = Math.max(brokenWallMax, map.get(tmp) + map.get(roomNum[i][j]));
					tmp = roomNum[i][j];
				}
			}
		}
		
		// 세로 방향으로 확인
		for (int j = 0; j < M; j++) {

			tmp = roomNum[0][j];

			for (int i = 0; i < N; i++) {
				if (tmp != roomNum[i][j]) {
					brokenWallMax = Math.max(brokenWallMax, map.get(tmp) + map.get(roomNum[i][j]));
					tmp = roomNum[i][j];
				}
			}
		}

		sb.append(room).append("\n").append(squareMax).append("\n").append(brokenWallMax);

		System.out.println(sb.toString());
	}

	private static void bfs(int starti, int startj, int num) {

		Queue<Point> queue = new ArrayDeque<>();

		roomNum[starti][startj] = num;
		visit[starti][startj] = true;
		queue.offer(new Point(starti, startj));

		int cnt = 1;

		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nexti = cur.i + di[d];
				int nextj = cur.j + dj[d];

				// 범위 밖이거나 벽이 있거나 방문한 경우 continue
				if (nexti < 0 || nexti >= N || nextj < 0 | nextj >= M || ((1 << d) & arr[cur.i][cur.j]) != 0
						|| visit[nexti][nextj])
					continue;

				visit[nexti][nextj] = true;
				queue.offer(new Point(nexti, nextj));
				roomNum[nexti][nextj] = num; // 방 번호 표시
				cnt++; // 방 넓이
			}
		} // end while

		squareMax = Math.max(squareMax, cnt); // 가장 넓은 방의 넓이 갱신
		map.put(num, cnt); // 방 번호별 넓이 입력

	}

	static class Point {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

}