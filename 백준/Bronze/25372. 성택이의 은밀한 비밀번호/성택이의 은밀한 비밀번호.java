import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String input = br.readLine();

			if (input.length() >= 6 && input.length() < 10) {
				sb.append("yes");
			} else {
				sb.append("no");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

}