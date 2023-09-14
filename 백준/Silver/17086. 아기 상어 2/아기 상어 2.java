import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, ans;
	static int[][] arr;
	static int[] di = { -1, 1, 0, 0, -1, 1, 1, -1 }; // 상,하,좌,우,왼위,왼하,우하,우상
	static int[] dj = { 0, 0, -1, 1, -1, -1, 1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];

		ans = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end input

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					bfs(i, j);
				}
			}
		}

		System.out.println(ans);
	}

	private static void bfs(int starti, int startj) {

		Queue<Point> queue = new PriorityQueue<>();
		boolean[][] visit = new boolean[N][M];

		queue.offer(new Point(starti, startj, 0));
		visit[starti][startj] = true;

		int min = Integer.MAX_VALUE;

		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			if (arr[cur.i][cur.j] == 1) {
				min = Math.min(min, cur.dis);
				continue;
			}

			for (int d = 0; d < 8; d++) {
				int nexti = cur.i + di[d];
				int nextj = cur.j + dj[d];

				if (nexti < 0 || nexti >= N || nextj < 0 || nextj >= M || visit[nexti][nextj])
					continue;

				int distance = cur.dis + 1;

				if (distance > min)
					continue;

				visit[nexti][nextj] = true;
				queue.offer(new Point(nexti, nextj, distance));
			}
		} // end while

		ans = Math.max(ans, min);
	}

	static class Point implements Comparable<Point> {
		int i, j, dis;

		public Point(int i, int j, int dis) {
			this.i = i;
			this.j = j;
			this.dis = dis;
		}

		@Override
		public int compareTo(Point o) {
			return this.dis - o.dis;
		}
	}

}