import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int end = N - 1;

		if (N % 2 == 0) {
			end = N;
		}

		for (int i = 1; i <= end; i++) {
			if (i % 2 == 1) {
				sb.append("1");
			} else {
				sb.append("2");
			}
			sb.append(" ");
		}

		if (end == N - 1)
			sb.append("3");

		System.out.println(sb.toString());

	}

}