import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		for (int idx = 0; idx < N; idx++) {

			for (int i = 0; i < idx; i++) {
				sb.append(" ");
			}
			for (int i = N - idx; i > 0; i--) {
				sb.append("*");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());

	}

}
