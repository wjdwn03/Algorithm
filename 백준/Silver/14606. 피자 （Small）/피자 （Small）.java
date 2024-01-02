import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		dp = new int[N + 1];

		dfs(N);

		System.out.println(dp[N]);
	}

	private static int dfs(int n) {

		if (n <= 1)
			return 0;

		if (dp[n] == 0) {

			dp[n] = n / 2 * (n - n / 2) + dfs(n / 2) + dfs(n - n / 2);
		}

		return dp[n];

	}

}