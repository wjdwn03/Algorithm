import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());

			String order = st.nextToken();

			if (order.equals("push")) {
				stack.add(Integer.parseInt(st.nextToken()));
			} else if (order.equals("pop")) {
				if (emptyCheck(stack)) {
					sb.append(-1).append("\n");
				} else {
					sb.append(stack.pop()).append("\n");
				}
			} else if (order.equals("size")) {
				sb.append(stack.size()).append("\n");
			} else if (order.equals("empty")) {
				if (emptyCheck(stack)) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
			} else if (order.equals("top")) {
				if (emptyCheck(stack)) {
					sb.append(-1).append("\n");
				} else {
					sb.append(stack.peek()).append("\n");
				}
			}
		} // end for t
		
		System.out.println(sb.toString());

	} // end main

	private static boolean emptyCheck(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return true;
		}
		return false;
	}

}