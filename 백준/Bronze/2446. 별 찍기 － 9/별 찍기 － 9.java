import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				sb.append(" ");
			}

			int end = 2 * N - 1 - 2 * i;
			for (int j = 0; j < end; j++) {
				sb.append("*");
			}

			sb.append("\n");
		}

		for (int i = N - 2; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				sb.append(" ");
			}
			int end = 2 * N - 1 - 2 * i;
			for (int j = 0; j < end; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

}