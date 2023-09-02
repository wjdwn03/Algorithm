import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			Queue<Integer> document = new ArrayDeque<>();
			Queue<Integer> indexQueue = new ArrayDeque<>();

			st = new StringTokenizer(br.readLine());

			for (int n = 0; n < N; n++) {
				indexQueue.add(n);
				document.add(Integer.parseInt(st.nextToken()));
			}

			int cnt = 1;

			while (!document.isEmpty()) {
				int max = Collections.max(document);
				int curDoc = document.poll();
				int curIdx = indexQueue.poll();

				if (curDoc == max) {

					if (curIdx == M) {
						break;
					}
					cnt++;
				}

				else {
					document.offer(curDoc);
					indexQueue.offer(curIdx);
				}

			}

			sb.append(cnt).append("\n");

		}

		System.out.println(sb.toString());
	}

}