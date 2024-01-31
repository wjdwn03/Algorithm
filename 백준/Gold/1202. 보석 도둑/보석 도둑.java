import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Jewel[] arr = new Jewel[N];
		Integer[] bags = new Integer[K];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int m = Integer.parseInt(st.nextToken());
			long v = Long.parseLong(st.nextToken());

			arr[i] = new Jewel(m, v);
		}

		for (int i = 0; i < K; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		} // end input

		Arrays.sort(arr);
		Arrays.sort(bags);

		long ans = 0L;
		int idx = 0;

		Queue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < K; i++) {

			while (idx < N && arr[idx].m <= bags[i]) {
				pq.offer(arr[idx++].v);
			}

			if (!pq.isEmpty())
				ans += pq.poll();
		}

		System.out.println(ans);

	}

	static class Jewel implements Comparable<Jewel> {
		int m;
		long v;

		public Jewel(int m, long v) {
			this.m = m;
			this.v = v;
		}

		@Override
		public int compareTo(Jewel o) {

			if (this.m == o.m) {
				return Long.compare(o.v, this.v);
			}
			return this.m - o.m;
		}
	}

}