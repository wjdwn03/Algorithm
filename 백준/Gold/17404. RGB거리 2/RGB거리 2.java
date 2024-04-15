import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] cost;
	static int[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		int ans = 1000 * 1000;

		cost = new int[N + 1][3];
		dp = new int[N + 1][3];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end input

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == j)
					dp[1][j] = cost[1][j];
				else
					dp[1][j] = 1000 * 1000;
			}

			for (int idx = 2; idx <= N; idx++) {
				dp[idx][0] = Math.min(dp[idx - 1][1], dp[idx - 1][2]) + cost[idx][0];
				dp[idx][1] = Math.min(dp[idx - 1][0], dp[idx - 1][2]) + cost[idx][1];
				dp[idx][2] = Math.min(dp[idx - 1][0], dp[idx - 1][1]) + cost[idx][2];
			}

			for (int j = 0; j < 3; j++) {
				if (i != j)
					ans = Math.min(ans, dp[N][j]);
			}
		}

		System.out.println(ans);
	}

}