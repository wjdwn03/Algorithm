import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] input;
	static int[] num;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		input = new int[N]; // input 저장할 배열
		num = new int[M]; // 수열 담을 배열

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(input);

		comb(0, 0);

		System.out.println(sb.toString());

	}

	private static void comb(int start, int cnt) {

		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(num[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i < N; i++) {
			num[cnt] = input[i];
			comb(i, cnt + 1);
		}

	}

}