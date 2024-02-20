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

	static int N;
	static List<Computer>[] list;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
			int d = Integer.parseInt(st.nextToken()); // 의존성 개수
			int c = Integer.parseInt(st.nextToken()); // 해킹당한 컴퓨터 번호

			list = new ArrayList[N + 1];

			for (int i = 1; i <= N; i++) {
				list[i] = new ArrayList<>();
			}

			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(st.nextToken()); // 자식
				int b = Integer.parseInt(st.nextToken()); // 부모
				int s = Integer.parseInt(st.nextToken()); // time

				list[b].add(new Computer(a, s));
			}

			dijkstra(c);
		}

		System.out.println(sb.toString());
	}

	private static void dijkstra(int start) {
		Queue<Computer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.time, o2.time));

		int[] arr = new int[N + 1];
		Arrays.fill(arr, Integer.MAX_VALUE);

		arr[start] = 0;
		pq.offer(new Computer(start, 0));

		int cnt = 0, time = 0;

		while (!pq.isEmpty()) {
			Computer cur = pq.poll();

			for (Computer next : list[cur.num]) {
				if (arr[next.num] <= cur.time + next.time)
					continue;

				arr[next.num] = cur.time + next.time;
				pq.offer(new Computer(next.num, arr[next.num]));
			}
		} // end while

		for (int i = 1; i <= N; i++) {
			if (arr[i] == Integer.MAX_VALUE)
				continue;
			time = Math.max(time, arr[i]);
			cnt++;
		}
		sb.append(cnt).append(" ").append(time).append("\n");
	}

	static class Computer {
		int num, time;

		public Computer(int num, int time) {
			this.num = num;
			this.time = time;
		}
	}

}