import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int k = 0;

		for (int i = 0; i < n; i++) {
			k = Integer.parseInt(br.readLine());

			for (int j = 0; j < k; j++) {
				sb.append("=");
			}

			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

}