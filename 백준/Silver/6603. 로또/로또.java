import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int K;
	static int[] input;
	static int[] numbers;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		K = Integer.parseInt(st.nextToken());

		while (K != 0) {

			input = new int[K];
			numbers = new int[6];

			for (int i = 0; i < K; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}

			comb(0, 0);
			sb.append("\n");

			st = new StringTokenizer(br.readLine());

			K = Integer.parseInt(st.nextToken());
		}

		System.out.println(sb.toString());
	}

	private static void comb(int start, int cnt) {

		if (cnt == 6) {
			for (int i = 0; i < 6; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i < K; i++) {
			numbers[cnt] = input[i];
			comb(i + 1, cnt + 1);
		}
	}

}