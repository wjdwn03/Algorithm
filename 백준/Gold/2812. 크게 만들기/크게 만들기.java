import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		String num = br.readLine();

		Deque<Integer> stack = new ArrayDeque<>();

		int cnt = 0;
		int idx = -1;

		for (int i = 0; i < N; i++) {
			int now = num.charAt(i) - '0';

			if (!stack.isEmpty()) {
				while (!stack.isEmpty() && cnt < K) {
					if (stack.peek() < now) {
						stack.pop();
						cnt++;
					} else {
						break;
					}
				} // end while
			}

			stack.push(now);

			if (cnt == K) {
				idx = i + 1;
				break;
			}

		}

		if (idx == -1) {
			while (stack.size() > K - cnt) {
				sb.append(stack.pollLast());
			}
		} else {
			while (!stack.isEmpty()) {
				sb.append(stack.pollLast());
			}

			for (int i = idx; i < N; i++) {
				sb.append(num.charAt(i));
			}
		}

		System.out.println(sb.toString());

	}

}