import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				sb.append("*");
			}
			for (int j = 1; j <= 2 * N - 2 * i; j++) {
				sb.append(" ");
			}
			for (int j = 1; j <= i; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}

		for (int i = 1; i < N; i++) {
			for (int j = 1; j <= N - i; j++) {
				sb.append("*");
			}
			for (int j = 1; j <= 2 * i; j++) {
				sb.append(" ");
			}
			for (int j = 1; j <= N - i; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

}