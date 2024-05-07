import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int to, dis;

	public Point(int next, int dis) {
		this.to = next;
		this.dis = dis;
	}
}

public class Main {

	static int N, E, u, v;
	static List<Point>[] list;
	static final int INF = 200_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list[a].add(new Point(b, c));
			list[b].add(new Point(a, c));
		}

		st = new StringTokenizer(br.readLine());

		u = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());

		// 1 -> u -> v -> N의 경로로 다익스트라 수행하는 경우
		int result1 = 0;
		result1 += bfs(1, u);
		result1 += bfs(u, v);
		result1 += bfs(v, N);

		// 1 -> v -> u -> N의 경로로 다익스트라 수행하는 경우
		int result2 = 0;
		result2 += bfs(1, v);
		result2 += bfs(v, u);
		result2 += bfs(u, N);

		if (result1 >= INF && result2 >= INF) {
			System.out.println("-1");
		} else {
			System.out.println(Math.min(result1, result2));
		}
	}

	private static int bfs(int start, int end) {

		Queue<Point> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.dis, o2.dis));
		boolean[] visit = new boolean[N + 1];
		int[] arr = new int[N + 1];

		Arrays.fill(arr, INF);
		pq.offer(new Point(start, 0));
		arr[start] = 0;

		while (!pq.isEmpty()) {
			Point cur = pq.poll();

			if (visit[cur.to])
				continue;

			visit[cur.to] = true;

			for (Point next : list[cur.to]) {
				if (!visit[next.to] && arr[next.to] > arr[cur.to] + next.dis) {
					arr[next.to] = arr[cur.to] + next.dis;
					pq.offer(new Point(next.to, arr[next.to]));
				}
			}
		}
		return arr[end];
	}

}