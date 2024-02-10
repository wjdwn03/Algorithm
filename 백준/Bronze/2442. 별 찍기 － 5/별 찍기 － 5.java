import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		for (int i = 1, idx = 1; i <= N; i++) {

			for (int j = N - i; j > 0; j--) {
				sb.append(" ");
			}

			for (int j = 1; j <= idx; j++) {
				sb.append("*");
			}
			sb.append("\n");
			idx += 2;
		}

		System.out.println(sb.toString());
	}

}