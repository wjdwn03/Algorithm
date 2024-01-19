import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		dp = new int[N + 1][K + 1];
		dp[1][1] = 1;

		int ans;

		if (N == K || K == 1) {
			ans = 1;
		} else {
			ans = dfs(N, K);
		}

		System.out.println(ans);
	}

	private static int dfs(int i, int j) {

		if (i < 1 || j < 1)
			return 0;

		if (dp[i][j] != 0)
			return dp[i][j];

		return dp[i][j] = dfs(i - 1, j - 1) + dfs(i - 1, j);
	}

}