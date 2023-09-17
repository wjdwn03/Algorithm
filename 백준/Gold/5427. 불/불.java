import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static char[][] arr;
	static int h, w, min;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());

			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			List<Point> fire = new LinkedList<>();
			arr = new char[h][w];

			min = Integer.MAX_VALUE;

			int starti = 0;
			int startj = 0;

			for (int i = 0; i < h; i++) {
				String tmp = br.readLine();

				for (int j = 0; j < w; j++) {
					arr[i][j] = tmp.charAt(j);
					if (arr[i][j] == '*') {
						fire.add(new Point(i, j));
					} else if (arr[i][j] == '@') {
						starti = i;
						startj = j;
					}
				}
			} // end input

			bfs(fire, starti, startj);

			if (min == Integer.MAX_VALUE) {
				sb.append("IMPOSSIBLE");
			} else {
				sb.append(min);
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());

	}

	private static void bfs(List<Point> fire, int starti, int startj) {

		Queue<Point> queue = new ArrayDeque<>();
		boolean[][] visit = new boolean[h][w];

		int time = 0;
		queue.offer(new Point(starti, startj));
		visit[starti][startj] = true;

		while (!queue.isEmpty()) {
			int size = queue.size();

			fire = moveFire(fire);

			for (int s = 0; s < size; s++) {

				Point cur = queue.poll();

				if (cur.i == 0 || cur.i == h - 1 || cur.j == 0 || cur.j == w - 1) {
					min = Math.min(min, cur.time + 1);
					return;
				}

				for (int d = 0; d < 4; d++) {
					int nexti = cur.i + di[d];
					int nextj = cur.j + dj[d];

					if (nexti < 0 || nexti >= h || nextj < 0 || nextj >= w || visit[nexti][nextj]
							|| arr[nexti][nextj] == '#' || arr[nexti][nextj] == '*')
						continue;
					visit[nexti][nextj] = true;
					queue.offer(new Point(nexti, nextj, cur.time + 1));

				}
			}

		}

	}

	private static List<Point> moveFire(List<Point> fire) {

		List<Point> tmp = new LinkedList<>();

		for (Point cur : fire) {
			for (int d = 0; d < 4; d++) {
				int nexti = cur.i + di[d];
				int nextj = cur.j + dj[d];
				if (nexti < 0 || nexti >= h || nextj < 0 || nextj >= w || arr[nexti][nextj] == '#'
						|| arr[nexti][nextj] == '*')
					continue;
				arr[nexti][nextj] = '*';
				tmp.add(new Point(nexti, nextj));
			}
		}
		return tmp;
	}

	static class Point {
		int i, j, time;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}

		public Point(int i, int j, int time) {
			this.i = i;
			this.j = j;
			this.time = time;
		}
	}

}