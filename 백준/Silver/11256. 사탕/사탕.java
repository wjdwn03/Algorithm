import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Collections;

import java.util.Queue;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());

			int J = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());

			Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

			int sum = 0;
			int cnt = 0;
			boolean check = true;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());

				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				pq.add(r * c);

			}

			for (int i = N - 1; i >= 0; i--) {

				sum += pq.poll();

				cnt++;

				if (sum >= J) {
					break;
				}
			}

			sb.append(cnt).append("\n");
		} // end for t

		System.out.println(sb.toString());
	}

}