import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String input = br.readLine();

		int len = input.length();

		for (int i = 0; i < len; i++) {

			char now = input.charAt(i);
			if (now >= 'A' && now <= 'Z') {
				sb.append((char) (now - 'A' + 'a'));
			} else {
				sb.append((char) (now - 'a' + 'A'));
			}
		}

		System.out.println(sb.toString());

	}

}