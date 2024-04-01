import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		char[] input = br.readLine().toCharArray();

		int size = input.length;

		for (int i = 0; i < size; i++) {

			sb.append(input[i]);

			if (i > 1 && (i + 1) % 10 == 0)
				sb.append("\n");

		}

		System.out.println(sb.toString());
	}

}