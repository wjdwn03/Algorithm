import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = br.readLine();

		while (!input.equals(".")) {

			Deque<Character> stack = new ArrayDeque<>();

			int size = input.length();

			char now = ' ';
			boolean balance = false;

			for (int i = 0; i < size; i++) {
				now = input.charAt(i);

				if (now == '(' || now == '[') {
					stack.push(now);
				} else if (now == ')') {

					if (stack.isEmpty() || stack.peek() != '(') {
						break;
					} else {
						stack.poll();
					}
				} else if (now == ']') {
					if (stack.isEmpty() || stack.peek() != '[') {
						break;
					} else {
						stack.poll();
					}
				} else if (now == '.') {
					if (stack.isEmpty()) {
						balance = true;
						break;
					}
				} else
					continue;
			}

			if (balance) {
				sb.append("yes");
			} else {
				sb.append("no");
			}
			sb.append("\n");

			input = br.readLine();
		}

		System.out.println(sb.toString());
	}

}