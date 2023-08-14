import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		int ans = 0;
		long aSum = 0L;

		Queue<Town> queue = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			aSum += (long) a;

			queue.offer(new Town(x, a));
		}

		if (N == 1) {
			ans = queue.poll().x;
		} else {

			long sum = 0L;

			for (int i = 0; i < N; i++) {
				Town now = queue.poll();

				sum += (long) now.a;

				if (sum >= (aSum + 1) / 2) {

					ans = now.x;
					break;
				}

			}
		}

		System.out.println(ans);

	}

	static class Town implements Comparable<Town> {
		int x, a;

		public Town(int x, int a) {
			this.x = x;
			this.a = a;
		}

		@Override
		public int compareTo(Town o) {

			if (this.x == o.x) {
				return this.a - o.a;
			} else {
				return this.x - o.x;
			}
		}
	}

}