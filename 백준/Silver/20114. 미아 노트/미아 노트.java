import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		String[] input = new String[H];

		for (int i = 0; i < H; i++) {
			input[i] = br.readLine();
		}

		for (int i = 0; i < N * W; i += W) {

			boolean check = false;

			for (int j = 0; j < W; j++) {

				if (check) {
					break;
				}

				for (int h = 0; h < H; h++) {
					if (input[h].charAt(i + j) != '?') {
						check = true;
						sb.append(input[h].charAt(i + j));
						break;
					}
				}

			}

			if (!check)
				sb.append("?");
		}

		System.out.println(sb);
	}

}