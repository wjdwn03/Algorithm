import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R, C;
	static int ans;
	static char[][] maze;
	static int[][] fireMap;
	static List<Point> fire;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		maze = new char[R][C];
		fireMap = new int[R][C];
		fire = new ArrayList<>();
		int starti = 0, startj = 0;

		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				maze[i][j] = input.charAt(j);
				if (maze[i][j] == 'J') {
					starti = i;
					startj = j;
				} else if (maze[i][j] == 'F') {
					fire.add(new Point(i, j));
					fireMap[i][j] = 1;
				}
			}
		} // end input

		// 불 먼저 전체에 퍼뜨려 놓음.
		moveFire();

		ans = bfs(starti, startj);

		if (ans == -1) {
			System.out.println("IMPOSSIBLE");
		} else {
			System.out.println(ans);
		}

	}

	private static int bfs(int starti, int startj) {
		Queue<Point> queue = new PriorityQueue<>();
		boolean[][] visit = new boolean[R][C];

		queue.offer(new Point(starti, startj, 0));
		visit[starti][startj] = true;

		int nexti = 0, nextj = 0;

		while (!queue.isEmpty()) {

			Point cur = queue.poll();

			for (int d = 0; d < 4; d++) {
				nexti = cur.i + di[d];
				nextj = cur.j + dj[d];

				// 탈출 성공
				if (nexti < 0 || nexti >= R || nextj < 0 || nextj >= C)
					return cur.time + 1;

				// 지훈이가 이동할 수 없는 곳
				if (maze[nexti][nextj] == '#' || maze[nexti][nextj] == 'F' || visit[nexti][nextj]
						|| (fireMap[nexti][nextj] > 0 && cur.time + 1 >= fireMap[nexti][nextj] - 1))
					continue;

				visit[nexti][nextj] = true;
				queue.add(new Point(nexti, nextj, cur.time + 1));
			}
		}

		return -1;
	}

	static public void moveFire() {

		Queue<Point> queue = new ArrayDeque<>();

		int size = fire.size();

		for (int i = 0; i < size; i++) {
			queue.offer(new Point(fire.get(i).i, fire.get(i).j, 1));
		}

		while (!queue.isEmpty()) {
			size = queue.size();

			for (int s = 0; s < size; s++) {

				Point now = queue.poll();

				for (int d = 0; d < 4; d++) {
					int nexti = now.i + di[d];
					int nextj = now.j + dj[d];

					if (nexti < 0 || nexti >= R || nextj < 0 || nextj >= C || maze[nexti][nextj] == '#'
							|| fireMap[nexti][nextj] != 0)
						continue;

					fireMap[nexti][nextj] = now.time + 1;
					queue.offer(new Point(nexti, nextj, now.time + 1));
				}
			}
		}

	}

	static class Point implements Comparable<Point> {
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

		@Override
		public int compareTo(Point o) {
			return this.time - o.time;
		}
	}

}