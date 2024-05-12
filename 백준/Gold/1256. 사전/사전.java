import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K;
	static long[][] dp;
	static StringBuilder sb;
	static final int INF = 1_000_000_001;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		dp = new long[N + M + 2][N + M + 2];

		for (int i = 0; i <= N + M; i++) {
			dp[i][0] = 1;
			dp[i][1] = i;
			dp[i][i] = 1;
		}

		for (int i = 1; i <= N + M; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i][j] = Math.min(dp[i - 1][j] + dp[i - 1][j - 1], INF);
			}

		}

		if (dp[N + M][M] < K)
			sb.append("-1");
		else {
			int n = N, m = M, k = K;

			while (n > 0 || m > 0) {
				if (dp[n + m - 1][m] >= k) {
					sb.append("a");
					n--;
				} else {
					sb.append("z");
					k -= dp[n + m - 1][m];
					m--;
				}
			}
		}

		System.out.println(sb.toString());

	}

}