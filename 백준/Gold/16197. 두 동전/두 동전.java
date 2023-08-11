import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, ans;
	static char[][] board;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int ai = -1, aj = -1;
		int bi = -1, bj = -1;

		board = new char[N][M];

		for (int i = 0; i < N; i++) {
			String m = br.readLine();

			for (int j = 0; j < M; j++) {
				board[i][j] = m.charAt(j);

				if (board[i][j] == 'o') {
					if (ai == -1) {
						ai = i;
						aj = j;
					} else {
						bi = i;
						bj = j;
					}
				}
			}
		} // end input

		ans = Integer.MAX_VALUE;

		bfs(ai, aj, bi, bj);

		System.out.println(ans);

	}

	private static void bfs(int ai, int aj, int bi, int bj) {
		Queue<Point> queue = new ArrayDeque<>();

		boolean[][] visit = new boolean[N][M];

		queue.offer(new Point(ai, aj, bi, bj, 0));

		visit[ai][aj] = true;
		visit[bi][bj] = true;

		int cnt = 0;

		while (!queue.isEmpty()) {

			int S = queue.size();

			cnt++;

			for (int s = 0; s < S; s++) {

				Point cur = queue.poll();

				if (cur.cnt >= 10) {
					ans = -1;
					return;
				}

				for (int d = 0; d < 4; d++) {
					int anexti = cur.ai + di[d];
					int anextj = cur.aj + dj[d];
					int bnexti = cur.bi + di[d];
					int bnextj = cur.bj + dj[d];

					// 둘 다 범위 밖인 경우
					if ((anexti < 0 || anexti >= N || anextj < 0 || anextj >= M)
							&& (bnexti < 0 || bnexti >= N || bnextj < 0 || bnextj >= M))
						continue;

					// 하나만 범위 밖인 경우
					if (anexti < 0 || anexti >= N || anextj < 0 || anextj >= M) {
						ans = Math.min(ans, cur.cnt + 1);
						return;
					}
					if (bnexti < 0 || bnexti >= N || bnextj < 0 || bnextj >= M) {
						ans = Math.min(ans, cur.cnt + 1);
						return;
					}
					if (visit[anexti][anextj] && visit[bnexti][bnextj])
						continue;

					if (board[anexti][anextj] == '#') {
						anexti = cur.ai;
						anextj = cur.aj;
					}
					if (board[bnexti][bnextj] == '#') {
						bnexti = cur.bi;
						bnextj = cur.bj;
					}

					queue.offer(new Point(anexti, anextj, bnexti, bnextj, cnt));

				} // end for d
			}
		} // end while

	}

	static class Point {
		int ai, aj, bi, bj, cnt;

		public Point(int ai, int aj, int bi, int bj, int cnt) {
			this.ai = ai;
			this.aj = aj;
			this.bi = bi;
			this.bj = bj;
			this.cnt = cnt;
		}
	}
}