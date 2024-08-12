import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[n + 1];
		int[] arr = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		if (n == 1) {

			System.out.println(arr[n]);

		} else if (n >= 2) {

			dp[1] = arr[1];
			dp[2] = arr[2] + arr[1];

			if (n > 2) {

				int glassOne, glassTwo, glassThree = 0;

				for (int i = 3; i <= n; i++) {
					glassOne = dp[i - 3] + arr[i - 1] + arr[i];
					glassTwo = dp[i - 2] + arr[i];
					glassThree = dp[i - 1];

					dp[i] = Math.max(glassOne, Math.max(glassTwo, glassThree));
				}

			}

			System.out.println(dp[n]);
		}
	}

}