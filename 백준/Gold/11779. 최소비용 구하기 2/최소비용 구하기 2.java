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

	static int N, M, start, end;
	static List<Point>[] list;
	static int[] arr;
	static int[] route;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		list = new ArrayList[N + 1];
		arr = new int[N + 1];
		route = new int[N + 1];

		Arrays.fill(arr, Integer.MAX_VALUE);

		// 초기화
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			start = Integer.parseInt(st.nextToken()); // 출발 도시 번호
			end = Integer.parseInt(st.nextToken()); // 도착 도시 번호
			int cost = Integer.parseInt(st.nextToken()); // 버스 번호

			list[start].add(new Point(end, cost));
		}

		st = new StringTokenizer(br.readLine());

		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		// end input

		bfs();

		sb.append(arr[end]).append("\n");

		String path = String.valueOf(end);
		int cnt = 1;
		int idx = route[end];

		while (idx != 0) {
			path = " " + path;
			cnt++;

			path = String.valueOf(idx) + path;
			idx = route[idx];
		}

		sb.append(cnt).append("\n").append(path);
		System.out.println(sb.toString());

	}

	private static void bfs() {
		Queue<Point> pq = new PriorityQueue<>();
		boolean[] visit = new boolean[N + 1];

		arr[start] = 0;
		route[start] = 0;
		pq.offer(new Point(start, 0));

		while (!pq.isEmpty()) {
			Point cur = pq.poll();

			if (visit[cur.num])
				continue;

			visit[cur.num] = true;

			for (Point next : list[cur.num]) {

				int nextCost = arr[cur.num] + next.cost;

				if (arr[next.num] <= nextCost)
					continue;
                
				arr[next.num] = nextCost;
				route[next.num] = cur.num;
				pq.offer(new Point(next.num, nextCost));
			}
		}

	}

	static class Point implements Comparable<Point> {
		int num, cost;

		public Point(int num, int cost) {
			this.num = num;
			this.cost = cost;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

}