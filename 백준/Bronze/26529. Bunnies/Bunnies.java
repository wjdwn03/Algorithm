import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int n;
	static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());

		dp = new int[46];
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 0; i < n; i++) {

			int x = Integer.parseInt(br.readLine());

			sb.append(fibo(x)).append("\n");
		}

		System.out.println(sb.toString());
	}

	private static int fibo(int num) {

		if (dp[num] != 0) {
			return dp[num];
		}

		dp[num] = fibo(num - 1) + fibo(num - 2);
		return dp[num];
	}

}