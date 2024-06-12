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

	public Point(int to, int dis) {
		this.to = to;
		this.dis = dis;
	}
}

public class Main {

	static int N, M, s, t;
	static List<Point>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];

		// initialization
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());

			list[from].add(new Point(to, dis));
			list[to].add(new Point(from, dis));
		}

		st = new StringTokenizer(br.readLine());

		s = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		int ans = dijkstra();

		System.out.println(ans);
	}

	private static int dijkstra() {
		Queue<Point> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.dis, o2.dis));
		int[] distance = new int[N + 1];

		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[s] = 0;
		pq.add(new Point(s, 0));

		while (!pq.isEmpty()) {
			Point cur = pq.poll();

			if (cur.to == t)
				break;

			for (Point next : list[cur.to]) {
				if (distance[next.to] >= distance[cur.to] + next.dis) {
					distance[next.to] = distance[cur.to] + next.dis;
					pq.add(new Point(next.to, distance[next.to]));
				}
			}
		} // end while

		return distance[t];
	}

}