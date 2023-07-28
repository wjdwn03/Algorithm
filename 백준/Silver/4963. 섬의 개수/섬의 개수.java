import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int w, h, cnt;
	static int[][] arr;
	static boolean[][] visit;
	static int[] di = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dj = { 0, 0, -1, 1, 1, -1, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());

			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0) {
				break;
			}

			arr = new int[h][w];
			visit = new boolean[h][w];
			cnt = 0;

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			} // end input

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!visit[i][j] && arr[i][j] == 1) {
						bfs(i, j);
						cnt++;
					}
				}
			}

			sb.append(cnt).append("\n");

		} // end while

		System.out.println(sb.toString());
	}

	private static void bfs(int nowi, int nowj) {

		Queue<Point> queue = new ArrayDeque<>();

		queue.offer(new Point(nowi, nowj));

		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			for (int d = 0; d < 8; d++) {
				int nexti = cur.i + di[d];
				int nextj = cur.j + dj[d];

				if (nexti < 0 || nexti >= h || nextj < 0 || nextj >= w || visit[nexti][nextj])
					continue;

				visit[nexti][nextj] = true;

				// 다음이 섬인 경우에만 이동한다.
				if (arr[nexti][nextj] == 1) {
					queue.offer(new Point(nexti, nextj));
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