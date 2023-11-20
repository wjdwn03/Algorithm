import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, cnt, time;
	static int[][] cheese;
	static boolean[][] air;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		cheese = new int[N][M];
		cnt = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
				if (cheese[i][j] == 1) {
					cnt++;
				}
			}
		}

		time = 0;

		while (cnt > 0) {
			time++;
			air = checkAir();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (cheese[i][j] == 1) {
						int around = 0;

						for (int d = 0; d < 4; d++) {
							int nexti = i + di[d];
							int nextj = j + dj[d];

							if (nexti < 0 || nexti >= N || nextj < 0 || nextj >= M || cheese[nexti][nextj] == 1
									|| !air[nexti][nextj])
								continue;

							around++;
						}

						if (around >= 2) {
							cheese[i][j] = 0;
							cnt--;
						}
					}
				} // end for j
			} // end for i
		} // end while

		System.out.println(time);
	}

	private static boolean[][] checkAir() {
		Queue<Point> queue = new ArrayDeque<>();
		boolean[][] visit = new boolean[N + 1][M + 1];

		visit[0][0] = true;
		queue.offer(new Point(0, 0));

		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nexti = cur.i + di[d];
				int nextj = cur.j + dj[d];

				if (nexti < 0 || nexti >= N || nextj < 0 || nextj >= M || visit[nexti][nextj]
						|| cheese[nexti][nextj] == 1)
					continue;

				visit[nexti][nextj] = true;
				queue.offer(new Point(nexti, nextj));

			}
		}

		return visit;

	}

	static class Point {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

}
