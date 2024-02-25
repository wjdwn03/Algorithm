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

		dp = new int[11][11];

		dfs(N, K);

		System.out.println(dp[N][K]);

	}

	private static int dfs(int nowi, int nowj) {

		if (dp[nowi][nowj] > 0)
			return dp[nowi][nowj];

		if (nowi == nowj || nowj == 0) {
			return dp[nowi][nowj] = 1;
		}

		return dp[nowi][nowj] = dfs(nowi - 1, nowj) + dfs(nowi - 1, nowj - 1);

	}

}