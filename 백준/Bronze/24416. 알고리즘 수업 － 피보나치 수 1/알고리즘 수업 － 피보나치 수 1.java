import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] dp;
	static int cntOne, cntTwo;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		cntOne = 1;
		cntTwo = 0;
		dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 1;

		fib(n);
		fibonacci(n);

		sb.append(cntOne).append(" ").append(cntTwo);

		System.out.println(sb.toString());

	}

	private static int fibonacci(int n) {

		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
			cntTwo++;
		}

		return dp[n];

	}

	private static int fib(int n) {

		if (n == 1 || n == 2) {
			return 1;
		} else {
			cntOne++;
			return fib(n - 1) + fib(n - 2);
		}

	}

}