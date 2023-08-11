import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int K;
	static long ans;
	static int[] chapter;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			K = Integer.parseInt(br.readLine());
			chapter = new int[K];

			st = new StringTokenizer(br.readLine());

			for (int k = 0; k < K; k++) {
				chapter[k] = Integer.parseInt(st.nextToken());
			} // end input

			ans = 0L;

			bfs();

			sb.append(ans).append("\n");
		} // end for t

		System.out.println(sb.toString());
	} // end main

	private static void bfs() {

		Queue<Long> queue = new PriorityQueue<>();

		for (int i = 0; i < K; i++) {
			queue.offer((long) chapter[i]);
		}

		while (!queue.isEmpty()) {
			long a = queue.poll();
			long b = queue.poll();

			ans += a + b;

			if (queue.isEmpty())
				break;

			queue.offer(a + b);
		}

	}

}