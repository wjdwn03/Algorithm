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

	static int N, M, ans;
	static List<Point>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];

		// 초기화
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		int from = 0, to = 0, w = 0;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());

			list[from].add(new Point(to, w));
			list[to].add(new Point(from, w));
		} // end input

		ans = bfs();
		System.out.println(ans);
	}

	private static int bfs() {
		Queue<Point> queue = new PriorityQueue<>();
		boolean[] visit = new boolean[N + 1];
		int size = list[1].size(); // list 배열의 크기

		int[] dist = new int[N + 1]; // 최소 여물 저장할 배열
		Arrays.fill(dist, Integer.MAX_VALUE); // 먼저 최대값으로 채운다.

		dist[1] = 0; // 시작 위치는 무조건 0이다.
		queue.offer(new Point(1, 0));

		while (!queue.isEmpty()) {

			Point cur = queue.poll();

			visit[cur.to] = true;

			size = list[cur.to].size();
			Point next;

			for (int i = 0; i < size; i++) {
				next = list[cur.to].get(i);

				if (visit[next.to])
					continue;

				// 최소 여물 양이 최소인 경우 갱신해주고 큐에 담는다.
				if (dist[next.to] > dist[cur.to] + next.w) {
					dist[next.to] = dist[cur.to] + next.w;
					queue.offer(new Point(next.to, dist[next.to]));
				}

			}

		} // end while

		return dist[N];
	}

	static class Point implements Comparable<Point> {
		int to, w;

		public Point(int to, int w) {
			this.to = to;
			this.w = w;
		}

		@Override
		public int compareTo(Point o) {
			return this.w - o.w;
		}
	}

}