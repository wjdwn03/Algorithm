import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String input = br.readLine();

		for (int i = 0; i < 3; i++) {
			sb.append(":fan:");
		}
		sb.append("\n");

		sb.append(":fan::").append(input).append("::fan:").append("\n");

		for (int i = 0; i < 3; i++) {
			sb.append(":fan:");
		}

		System.out.println(sb.toString());
	}

}