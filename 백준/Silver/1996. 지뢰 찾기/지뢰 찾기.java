import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static char[][] map;
	static char[][] ans;
	static int[] di = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dj = { 0, 0, -1, 1, 1, -1, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		map = new char[N][N];
		ans = new char[N][N];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			map[i] = input.toCharArray();
		}

		bfs();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(ans[i][j]);
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());

	}

	private static void bfs() {
		Queue<Point> queue = new ArrayDeque<>();
		boolean[][] visit = new boolean[N][N];

		queue.offer(new Point(0, 0));
		visit[0][0] = true;

		while (!queue.isEmpty()) {

			Point cur = queue.poll();
			if (map[cur.i][cur.j] != '.') {
				ans[cur.i][cur.j] = '*';
			}

			int cnt = 0;

			for (int d = 0; d < 8; d++) {
				int nexti = cur.i + di[d];
				int nextj = cur.j + dj[d];

				if (nexti < 0 || nexti >= N || nextj < 0 || nextj >= N)
					continue;

				if (map[nexti][nextj] != '.') {
					cnt += map[nexti][nextj] - '0';
				}

				if (visit[nexti][nextj])
					continue;
				queue.offer(new Point(nexti, nextj));
				visit[nexti][nextj] = true;

			}

			if (map[cur.i][cur.j] == '.') {

				if (cnt >= 10) {
					ans[cur.i][cur.j] = 'M';
				} else {
					ans[cur.i][cur.j] = Character.forDigit(cnt, 10);
				}
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