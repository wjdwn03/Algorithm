import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[N + 1];

		dp[1] = 1;

		int min = 0;

		for (int i = 2; i <= N; i++) {
			min = N;

			for (int j = 1; j * j <= i; j++) {
				int now = i - j * j;

				min = Math.min(min, dp[now]);
			}

			dp[i] = min + 1;
		}

		System.out.println(dp[N]);
	}

}