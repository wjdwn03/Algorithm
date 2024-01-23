import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, ans;
	static char[][] map;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];

		int starti = 0, startj = 0, peopleCnt = 0;

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
				if (map[i][j] == 'I') {
					starti = i;
					startj = j;
				} else if (map[i][j] == 'P')
					peopleCnt++;
			}
		} // end input

		ans = 0;

		bfs(starti, startj, peopleCnt);

		if (ans == 0) {
			sb.append("TT");
		} else {
			sb.append(ans);
		}

		System.out.println(sb.toString());
	}

	private static void bfs(int starti, int startj, int peopleCnt) {
		Queue<Point> queue = new ArrayDeque<>();
		boolean[][] visit = new boolean[N][M];

		queue.offer(new Point(starti, startj));
		visit[starti][startj] = true;

		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			if (map[cur.i][cur.j] == 'P') {
				map[cur.i][cur.j] = 'O';
				ans++;

				if (ans == peopleCnt)
					return;
			}

			for (int d = 0; d < 4; d++) {
				int nexti = cur.i + di[d];
				int nextj = cur.j + dj[d];

				if (nexti < 0 || nexti >= N || nextj < 0 || nextj >= M || visit[nexti][nextj]
						|| map[nexti][nextj] == 'X')
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