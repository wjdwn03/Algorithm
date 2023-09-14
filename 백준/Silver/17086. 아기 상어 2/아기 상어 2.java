import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, ans;
	static int[][] arr;
	static boolean[][] visit;
	static int[] di = { -1, 1, 0, 0, -1, 1, 1, -1 }; // 상,하,좌,우,왼위,왼하,우하,우상
	static int[] dj = { 0, 0, -1, 1, -1, -1, 1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visit = new boolean[N][M];

		ans = 0;

		Queue<Point> queue = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					queue.offer(new Point(i, j));
					visit[i][j] = true;
				}
			}
		} // end input

		bfs(queue);

		System.out.println(ans);
	}

	private static void bfs(Queue<Point> queue) {

		int cnt = -1;

		while (!queue.isEmpty()) {

			int size = queue.size();

			for (int s = 0; s < size; s++) {
				Point cur = queue.poll();

				for (int d = 0; d < 8; d++) {
					int nexti = cur.i + di[d];
					int nextj = cur.j + dj[d];

					if (nexti < 0 || nexti >= N || nextj < 0 || nextj >= M || visit[nexti][nextj])
						continue;

					visit[nexti][nextj] = true;
					queue.offer(new Point(nexti, nextj));
				}
			}
			cnt++;
		} // end while

		ans = cnt;

	}

	static class Point {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}

	}

}