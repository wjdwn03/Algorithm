import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K;
	static int[][] arr;
	static boolean[][] visit;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());

			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			arr = new int[M][N];
			visit = new boolean[M][N];

			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());

				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());

				arr[i][j] = 1;
			}

			int cnt = 0;

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 1 && !visit[i][j]) {
						bfs(i, j);
						cnt++;
					}
				}
			}

			sb.append(cnt).append("\n");
		} // end for t

		System.out.println(sb.toString());
	}

	private static void bfs(int starti, int startj) {

		Queue<Point> queue = new ArrayDeque<>();

		queue.offer(new Point(starti, startj));
		visit[starti][startj] = true;

		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nexti = cur.i + di[d];
				int nextj = cur.j + dj[d];

				if (nexti < 0 || nexti >= M || nextj < 0 || nextj >= N || visit[nexti][nextj] || arr[nexti][nextj] == 0)
					continue;

				visit[nexti][nextj] = true;
				queue.offer(new Point(nexti, nextj));
			}
		}

	}

	static class Point {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

}