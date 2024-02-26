import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static long[][][] dp;
	static final int MOD = 1_000_000_000;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		dp = new long[N + 1][10][1 << 10];

		for (int i = 1; i < 10; i++) {
			dp[1][i][1 << i] = 1;
		}

		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				for (int visit = 0; visit < 1024; visit++) {
					int now = visit | (1 << j);

					if (j == 0)
						dp[i][j][now] = (dp[i][j][now] + dp[i - 1][j + 1][visit]) % MOD;
					else if (j == 9)
						dp[i][j][now] = (dp[i][j][now] + dp[i - 1][j - 1][visit]) % MOD;
					else
						dp[i][j][now] = (dp[i][j][now] + dp[i - 1][j - 1][visit] + dp[i - 1][j + 1][visit]) % MOD;

				}
			}
		}

		long sum = 0L;

		for (int i = 0; i < 10; i++) {
			sum = (sum + dp[N][i][(1 << 10) - 1]) % MOD;
		}

		System.out.println(sum);
	}

}