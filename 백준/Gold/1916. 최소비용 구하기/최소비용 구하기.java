import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Bus implements Comparable<Bus> {
	int to, cost;

	public Bus(int to, int cost) {
		this.to = to;
		this.cost = cost;
	}

	@Override
	public int compareTo(Bus o) {
		return this.cost - o.cost;
	}
}

public class Main {

	static int N, M;
	static List<Bus>[] list;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		list = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[from].add(new Bus(to, cost));
		}

		st = new StringTokenizer(br.readLine());

		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		arr = new int[N + 1];

		Arrays.fill(arr, Integer.MAX_VALUE);
		arr[start] = 0;

		dijkstra(start, end);

		System.out.println(arr[end]);
	}

	private static void dijkstra(int start, int end) {

		Queue<Bus> pq = new PriorityQueue<>();
		boolean[] visit = new boolean[N + 1];

		pq.offer(new Bus(start, 0));

		while (!pq.isEmpty()) {
			Bus cur = pq.poll();

			if (!visit[cur.to]) {

				visit[cur.to] = true;

				for (Bus next : list[cur.to]) {
					if (!visit[next.to] && arr[next.to] > arr[cur.to] + next.cost) {
						arr[next.to] = arr[cur.to] + next.cost;
						pq.offer(new Bus(next.to, arr[next.to]));
					}
				}
			}
		}

	}

}