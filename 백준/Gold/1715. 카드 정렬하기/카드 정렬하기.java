import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		Queue<Long> queue = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			Long num = Long.parseLong(br.readLine());
			queue.offer(num);
		}

		long sum = 0L;
		long ans = sum;

		if (N > 1) {

			while (!queueEmptyCheck(queue)) {

				sum = queue.poll();

				if (!queueEmptyCheck(queue)) {
					sum += queue.poll();
				}

				if (!queueEmptyCheck(queue)) {
					queue.offer(sum);
				}
				ans += sum;

			}
		} else {
			ans = 0;
		}

		System.out.println(ans);
	}

	public static boolean queueEmptyCheck(Queue<Long> queue) {

		if (queue.isEmpty()) {
			return true;
		} else
			return false;
	}

}