import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] arr; // 초기 입력값
	static int[][] dis; // 목표지점까지의 거리 표시할 배열
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		dis = new int[N][M];

		int starti = 0, startj = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			Arrays.fill(dis[i], -1);

			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

				if (arr[i][j] == 0) {
					dis[i][j] = 0;
				} else if (arr[i][j] == 2) {
					dis[i][j] = 0;
					starti = i;
					startj = j;
				}
			}
		} // end input

		bfs(starti, startj);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(dis[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());

	}

	private static void bfs(int starti, int startj) {
		Queue<Point> queue = new ArrayDeque<>();
		boolean[][] visit = new boolean[N][M];

		visit[starti][startj] = true;
		queue.offer(new Point(starti, startj));

		int cnt = 0;

		while (!queue.isEmpty()) {

			int size = queue.size();

			for (int s = 0; s < size; s++) {

				Point cur = queue.poll();
				dis[cur.i][cur.j] = cnt;

				for (int d = 0; d < 4; d++) {
					int nexti = cur.i + di[d];
					int nextj = cur.j + dj[d];

					if (nexti < 0 || nexti >= N || nextj < 0 || nextj >= M || visit[nexti][nextj]
							|| arr[nexti][nextj] == 0)
						continue;

					queue.offer(new Point(nexti, nextj));
					visit[nexti][nextj] = true;
				}

			} // end for s

			cnt++;

		} // end while

	}

	static class Point {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

}