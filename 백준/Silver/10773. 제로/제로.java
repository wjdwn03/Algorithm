import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int K = Integer.parseInt(br.readLine());

		Deque<Integer> stack = new ArrayDeque<>();

		for (int k = 0; k < K; k++) {
			int now = Integer.parseInt(br.readLine());

			if (now == 0) {
				stack.pop();
			} else {
				stack.push(now);
			}
		}

		int sum = 0;

		while (!stack.isEmpty()) {
			sum += stack.pop();
		}

		System.out.println(sum);
	}

}