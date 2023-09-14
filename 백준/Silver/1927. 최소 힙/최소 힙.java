import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	static int N;
	static Queue<Integer> queue;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		queue = new PriorityQueue<>();
		int num = 0;

		for (int i = 0; i < N; i++) {
			num = Integer.parseInt(br.readLine());

			if (num == 0) {
				if (queue.isEmpty()) {
					sb.append("0");
				} else {
					sb.append(queue.poll());
				}
				sb.append("\n");
			} else {
				queue.add(num);
			}
		} // end for

		System.out.println(sb.toString());
	}

}