import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {

	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a == 0 && b == 0 && c == 0)
				break;

			int max = Math.max(Math.max(a, b), c);

			if (max == a) {
				check(b, c, a);
			} else if (max == b) {
				check(a, c, b);
			} else {
				check(a, b, c);
			}

		}

		System.out.println(sb.toString());
	}

	public static void check(int a, int b, int c) {
		if (a * a + b * b == c * c) {
			sb.append("right");
		} else {
			sb.append("wrong");
		}
		sb.append("\n");
	}

}