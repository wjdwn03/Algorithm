import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {

	static int N;
	static int[] arr;
	static long[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new int[N + 1];
		dp = new long[N + 1][21];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dp[1][arr[1]] = 1L;

		for (int i = 2; i < N; i++) {
			for (int j = 0; j <= 20; j++) {
				if (dp[i - 1][j] != 0) {
					int plus = j + arr[i];
					int minus = j - arr[i];

					if (plus >= 0 && plus <= 20) {
						dp[i][plus] += dp[i - 1][j];
					}

					if (minus >= 0 && minus <= 20) {
						dp[i][minus] += dp[i - 1][j];
					}
				} // end if
			} // end for j
		} // end for i

		// 문제에서 N-1번까지 계산을 한 결과를 N과 비교해야 하므로 N-1행을 확인함.
		System.out.println(dp[N - 1][arr[N]]);

	}

}