import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		Deque<Integer> deq = new ArrayDeque<>();

		for (int i = 1; i <= N; i++) {
			deq.addLast(i);
		}

		while (!deq.isEmpty()) {
			sb.append(deq.pollFirst()).append(" ");

			if (deq.isEmpty())
				break;

			deq.addLast(deq.pollFirst());
		}

		System.out.println(sb.toString());

	}

}