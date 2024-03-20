import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		Deque<Character> stackOne = new ArrayDeque<>();
		Deque<Character> stackTwo = new ArrayDeque<>();

		String N = br.readLine();
		int len = N.length();

		for (int i = 0; i < len; i++) {
			stackOne.push(N.charAt(i));
		}

		int M = Integer.parseInt(br.readLine());

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());

			String order = st.nextToken();

			if (order.equals("L")) {

				if (!stackOne.isEmpty()) {
					char now = stackOne.pop();
					stackTwo.push(now);
				}

			} else if (order.equals("D")) {
				if (!stackTwo.isEmpty()) {
					char now = stackTwo.pop();
					stackOne.push(now);
				}
			} else if (order.equals("B")) {

				if (!stackOne.isEmpty())
					stackOne.pop();

			} else {
				stackOne.push(st.nextToken().charAt(0));
			}

		} // end for m

		while (!stackOne.isEmpty()) {
			sb.append(stackOne.removeLast());
		}
		while (!stackTwo.isEmpty()) {
			sb.append(stackTwo.removeFirst());
		}

		System.out.println(sb.toString());

	}

}