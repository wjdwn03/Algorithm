import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String input;

		while (true) {
			input = br.readLine();
			if (input == null) {
				break;
			}
			sb.append(input).append("\n");
		}

		System.out.println(sb.toString());
	}

}