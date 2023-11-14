import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String input = br.readLine();

		int cnt = 0, size = 0;

		while (!input.equals("#")) {
			cnt = 0;
			size = input.length();

			for (int i = 0; i < size; i++) {
				// 모음이 있으면 개수 증가
				switch (input.charAt(i)) {
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
				case 'A':
				case 'E':
				case 'I':
				case 'O':
				case 'U':
					cnt++;
					break;
				}
			}

			sb.append(cnt).append("\n");

			input = br.readLine();
		}

		System.out.println(sb.toString());

	}

}