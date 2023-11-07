import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, maxH, ans;
	static int[][] arr;
	static boolean[][] rain;
	static boolean[][] visit;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];
		rain = new boolean[N][N];
		ans = 1;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				maxH = Math.max(maxH, arr[i][j]);
			}
		} // end input

		for (int r = 1; r <= maxH; r++) {
			rainCheck(r);

			visit = new boolean[N][N];
			int cnt = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visit[i][j] && !rain[i][j]) {
						bfs(i, j);
						cnt++;
					}
				}
			}

			ans = Math.max(ans, cnt);

		}

		System.out.println(ans);
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

				if (nexti < 0 || nexti >= N || nextj < 0 || nextj >= N || visit[nexti][nextj] || rain[nexti][nextj])
					continue;

				visit[nexti][nextj] = true;
				queue.add(new Point(nexti, nextj));
			}
		}

	}

	// 물에 잠기는거 확인
	private static void rainCheck(int r) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] > r || rain[i][j])
					continue;

				rain[i][j] = true;
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