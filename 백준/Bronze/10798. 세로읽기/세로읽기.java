import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		List<String> list = new ArrayList<>();

		String input = br.readLine();

		int max = 0;

		while (input != null && input.length() > 0) {

			list.add(input);
			max = Math.max(max, input.length());
			input = br.readLine();
		}

		char[][] arr = new char[list.size()][max];

		for (int i = 0; i < list.size(); i++) {

			Arrays.fill(arr[i], ' ');

			for (int j = 0; j < list.get(i).length(); j++) {
				arr[i][j] = list.get(i).charAt(j);
			}

		}

		for (int j = 0; j < max; j++) {
			for (int i = 0; i < list.size(); i++) {
				if (arr[i][j] != ' ') {
					sb.append(arr[i][j]);
				}
			}
		}

		System.out.println(sb.toString());

	}

}