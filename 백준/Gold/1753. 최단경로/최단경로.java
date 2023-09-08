import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int K;
	static List<Point>[] list;
	static long[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		K = Integer.parseInt(br.readLine());

		arr = new long[V + 1];
		list = new ArrayList[V + 1];

		// initialization
		for (int i = 0; i <= V; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			long w = Long.parseLong(st.nextToken());

			list[from].add(new Point(to, w));
		} // end input

		Arrays.fill(arr, Long.MAX_VALUE);
		arr[K] = 0L; // 시작점의 위치는 경로값이 없기 때문에 0이다.

		bfs(K);

		for (int i = 1; i <= V; i++) {
			if (arr[i] == Long.MAX_VALUE) {
				sb.append("INF");
			} else {
				sb.append(arr[i]);
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());

	}

	private static void bfs(int start) {

		Queue<Point> queue = new PriorityQueue<>();

		queue.offer(new Point(start, 0));

		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			for (int i = 0; i < list[cur.to].size(); i++) {

				Point next = list[cur.to].get(i);
				long w = cur.w + next.w;

				if (w >= arr[next.to]) {
					continue;
				}

//				arr[next.to] = Math.min(arr[next.to], w);
				arr[next.to] = w;

				queue.offer(new Point(next.to, w));

			} // end for i
		} // end while

	}

	static class Point implements Comparable<Point> {
		int to;
		long w;

		public Point(int to, long w) {
			this.to = to;
			this.w = w;
		}

		@Override
		public int compareTo(Point o) {
			return (int) (this.w - o.w);
		}

	}

}