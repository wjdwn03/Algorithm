import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, ans;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[101];

		for (int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			arr[from] = to;
		}

		ans = 101;

		bfs();

		System.out.println(ans);

	}

	public static void bfs() {
		Queue<Point> queue = new ArrayDeque<>();

		boolean[] visit = new boolean[101];

		queue.offer(new Point(1, 0));
		visit[1] = true;

		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			if (cur.cnt >= ans || cur.idx > 100)
				continue;

			if (cur.idx == 100) {
				ans = Math.min(ans, cur.cnt);
				return;
			}

			for (int i = 1; i < 7; i++) {
				int next = cur.idx + i;

				if (next > 100 || next < 1)
					continue;

				if (arr[next] != 0) {
					next = arr[next];
				}

				if (visit[next])
					continue;

				visit[next] = true;
				queue.offer(new Point(next, cur.cnt + 1));

			} // end for

		} // end while

	} // end bfs

	static class Point {
		int idx, cnt;

		public Point(int idx, int cnt) {
			this.idx = idx;
			this.cnt = cnt;
		}
	}

}