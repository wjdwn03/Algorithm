import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Building {

	int num;
	long sum;

	public Building(int num, long sum) {
		this.num = num;
		this.sum = sum;
	}

}

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int end = 0; // 목적지
			long[] time = new long[N + 1];
			long[] topology = new long[N + 1];
			long[] min = new long[N + 1];
			List<Integer>[] list = new ArrayList[N + 1];

			st = new StringTokenizer(br.readLine());

			for (int i = 1; i <= N; i++) {
				list[i] = new ArrayList<>(); // 초기화
				time[i] = Long.parseLong(st.nextToken());
			}

			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());

				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				topology[to]++;

				list[from].add(to);
			}

			end = Integer.parseInt(br.readLine());

			min = Arrays.copyOf(time, N + 1);

			Queue<Building> queue = new ArrayDeque<>();

			for (int i = 1; i <= N; i++) {
				if (topology[i] == 0) {
					queue.offer(new Building(i, time[i]));
				}
			}

			while (!queue.isEmpty()) {
				Building cur = queue.poll();

				for (int next : list[cur.num]) {
					min[next] = Math.max(min[next], cur.sum + time[next]);

					if (--topology[next] == 0) {
						queue.offer(new Building(next, min[next]));
					}
				}
			} // end while

			sb.append(min[end]).append("\n");
		}

		System.out.println(sb.toString());

	}

}