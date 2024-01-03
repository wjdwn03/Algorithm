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

		for (int i = 1; i <= N; i++) {
			dp[i] = (i / 2) * (i - i / 2) + dp[i / 2] + dp[i - i / 2];
		}

		System.out.println(dp[N]);
	}

}