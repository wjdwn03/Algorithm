import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			String input = br.readLine();

			int n = (int) Math.sqrt(input.length());

			for (int i = n - 1; i >= 0; i--) {
				for (int j = 0; j < n; j++) {
					int idx = i + j * n;
					sb.append(input.charAt(idx));
				}
			}

			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

}