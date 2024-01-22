import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		int[] dp = new int[N + 1];

		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		if (M == 0) {
			System.out.println(dp[N]);
		} else {

			int[] vip = new int[M];

			for (int i = 0; i < M; i++) {
				vip[i] = Integer.parseInt(br.readLine());
			}

			int ans = dp[vip[0] - 1];

			for (int i = 1; i < M; i++) {
				ans *= dp[vip[i] - vip[i - 1] - 1];

			}

			ans *= dp[N - vip[M - 1]];

			System.out.println(ans);
		}
	}

}