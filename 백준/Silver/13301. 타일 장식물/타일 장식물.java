import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static long[] dp;
	static long[] square;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		dp = new long[N + 1];
		square = new long[N + 1];

		square[0] = 4L;

		dp[0] = 1L;
		dp[1] = 1L;

		dfs(N);
		getSquare(N);

		System.out.println(square[N - 1]);

	}

	private static long getSquare(int n) {
		if (n < 1)
			return 4;
		if (square[n] != 0)
			return square[n];

		square[n] = getSquare(n - 1) + dp[n] * 2;

		return square[n];
	}

	private static long dfs(int n) {

		if (n < 2)
			return 1;

		if (dp[n] != 0)
			return dp[n];

		dp[n] = dfs(n - 1) + dfs(n - 2);

		return dp[n];
	}

}