import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		long[][] dp = new long[N + 1][10];

		long sum = 0L;

		for (int i = 0; i < 10; i++) {
			dp[0][i] = 1L;
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				for (int idx = j; idx < 10; idx++) {
					dp[i][j] += (dp[i - 1][idx] % 10007L);
				}
				dp[i][j] %= 10007;
			}
		}

		System.out.println(dp[N][0]);
	}

}