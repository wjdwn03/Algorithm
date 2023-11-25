import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String input = br.readLine();

		while (!input.equals("END")) {
			int size = input.length();

			for (int i = size - 1; i >= 0; i--) {
				sb.append(input.charAt(i));
			}

			sb.append("\n");

			input = br.readLine();
		}

		System.out.println(sb.toString());
	}

}