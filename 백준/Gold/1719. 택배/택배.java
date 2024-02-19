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

	static int N, M;
	static int[][] arr; // 정답 저장할 배열
	static List<Point>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N + 1][N + 1];
		list = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());

			list[from].add(new Point(to, time));
			list[to].add(new Point(from, time));
		} // end input

		for (int i = 1; i <= N; i++) {

			dijk(i);
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i != j) {
					sb.append(arr[i][j]).append(" ");
					continue;
				}
				sb.append("- ");

			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	private static void dijk(int from) {
		Queue<Point> pq = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);
		boolean[] visit = new boolean[N + 1];
		int[] min = new int[N + 1];

		Arrays.fill(min, Integer.MAX_VALUE);

		min[from] = 0;
		pq.offer(new Point(from, 0));

		while (!pq.isEmpty()) {
			Point cur = pq.poll();

			if (min[cur.idx] < cur.time)
				continue;
			if (!visit[cur.idx])
				visit[cur.idx] = true;

			for (Point next : list[cur.idx]) {
				int nextTime = cur.time + next.time;

				if (!visit[next.idx] && min[next.idx] > nextTime) {
					min[next.idx] = nextTime;
					arr[next.idx][from] = cur.idx;
					pq.offer(new Point(next.idx, nextTime));
				}

			}
		}

	}

	static class Point {
		int idx, time;

		public Point(int idx, int time) {
			this.idx = idx;
			this.time = time;
		}
	}

}