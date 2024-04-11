import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Deque<Integer> stack = new ArrayDeque<>();
		int idx = 0;
		int num = 1;
		boolean isPossible = true;

		while (idx < N) {
			if (!stack.isEmpty() && stack.peek() == arr[idx]) {
				stack.pop();
				idx++;
				sb.append("-");
			} else {
				if (num > N) {
					isPossible = false;
					break;
				}
				stack.push(num++);
				sb.append("+");
			}
			sb.append("\n");
		}

		if (!stack.isEmpty()) {
			isPossible = false;
		}

		if (isPossible) {
			System.out.println(sb.toString());
		} else {
			System.out.println("NO");
		}
	}

}