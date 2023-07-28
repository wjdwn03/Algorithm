import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, min;
	static int[][] maze;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		maze = new int[N][M];

		for (int i = 0; i < N; i++) {

			String str = br.readLine();

			for (int j = 0; j < M; j++) {
				maze[i][j] = str.charAt(j) - '0';
			}

		} // end input

		min = 10000;

		bfs(0, 0);

		System.out.println(min);

	}

	private static void bfs(int nowi, int nowj) {

		Queue<Point> queue = new PriorityQueue<>();
		boolean[][] visit = new boolean[N][M];

		queue.offer(new Point(nowi, nowj, 0));
		visit[nowi][nowj] = true;

		while (!queue.isEmpty()) {

			Point cur = queue.poll();

			if (cur.cnt >= min)
				continue;

			if (cur.i == N - 1 && cur.j == M - 1) {

				min = Math.min(min, cur.cnt);
				continue;
			}

			for (int d = 0; d < 4; d++) {
				int nexti = cur.i + di[d];
				int nextj = cur.j + dj[d];

				if (nexti < 0 || nexti >= N || nextj < 0 || nextj >= M || visit[nexti][nextj])
					continue;

				visit[nexti][nextj] = true;

				int cnt = cur.cnt;

				if (maze[nexti][nextj] == 1) {
					cnt += 1;
					maze[nexti][nextj] = 0;
				}

				queue.offer(new Point(nexti, nextj, cnt));
			}
		} // end while

	}

	static class Point implements Comparable<Point> {
		int i, j, cnt;

		public Point(int i, int j, int cnt) {
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Point o) {
			return this.cnt - o.cnt;
		}
	}
}