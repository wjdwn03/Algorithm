import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static long[] dp;
	static long[] gap;
	static final int MOD = 1_000_000_009;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		dp = new long[1_000_001];
		gap = new long[1_000_001];

		dp[1] = 1;
		gap[1] = 1;
		gap[2] = 2;

		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());

			dfs(n);

			sb.append(dp[n]).append("\n");
		}

		System.out.println(sb.toString());
	}

	private static long dfs(int n) {

		if (n < 2 || dp[n] != 0)
			return dp[n];

		return dp[n] = (dfs(n - 1) % MOD + getGap(n - 1) % MOD) % MOD;

	}

	private static long getGap(int idx) {

		if (idx < 3 || gap[idx] != 0)
			return gap[idx];

		return gap[idx] = (getGap(idx - 1) % MOD + getGap(idx - 2) % MOD + getGap(idx - 3) % MOD) % MOD;
	}

}