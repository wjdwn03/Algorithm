import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static long[] dp;
	static int[] input;
	static final int MOD = 1_000_000_009;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		dp = new long[1_000_001];
		input = new int[T];

		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		int max = 0;

		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());

			input[t] = n;
			max = Math.max(max, n);
		}

		for (int i = 4; i <= max; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % MOD;
		}
		for (int i = 0; i < T; i++) {
			sb.append(dp[input[i]]).append("\n");
		}

		System.out.println(sb.toString());
	}

}