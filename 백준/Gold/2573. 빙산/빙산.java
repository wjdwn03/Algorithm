import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] arr;
	static boolean[][] visit;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];

		int time = 0;
		int cnt = 0; // 빙산 조각 개수

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end input

//		boolean[][] visit = new boolean[N][M];

		while (true) {

			// 초기화
			cnt = 0;
			visit = new boolean[N][M];

			time++;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!visit[i][j] && arr[i][j] != 0) {
						bfs(i, j);
						cnt++;
					}
				}
				if (cnt > 1) {
					break;
				}
			}

			if (cnt == 0) {
				time = 0;
				break;
			} else if (cnt > 1) {
				time--;
				break;
			}
		} // end while

		System.out.println(time);
	}

	private static void bfs(int nowi, int nowj) {
		Queue<Point> queue = new ArrayDeque<>();

		queue.offer(new Point(nowi, nowj, 0));
		visit[nowi][nowj] = true;

		List<Point> list = new ArrayList<>();

		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			int zero = 0;

			for (int d = 0; d < 4; d++) {
				int nexti = cur.i + di[d];
				int nextj = cur.j + dj[d];

				if (nexti < 0 || nexti >= N || nextj < 0 || nextj >= M)
					continue;

				if (arr[nexti][nextj] == 0)
					zero++;
				if (visit[nexti][nextj])
					continue;

				if (arr[nexti][nextj] != 0) {
					queue.offer(new Point(nexti, nextj, 0));
					visit[nexti][nextj] = true;
				}

			}
			if (zero > 0) {
				list.add(new Point(cur.i, cur.j, arr[cur.i][cur.j] - zero));
			}
		} // end while

		for (int i = 0; i < list.size(); i++) {
			Point now = list.get(i);

			if (now.cnt <= 0) {
				arr[now.i][now.j] = 0;
			} else {
				arr[now.i][now.j] = now.cnt;
			}
		}

	}

	static class Point {
		int i, j, cnt;

		public Point(int i, int j, int cnt) {
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}
	}

}