import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n, ans;
	static int[] arr;
	static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		dp = new int[n + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());

		ans = Integer.MIN_VALUE;

		int start = 0, end = 0;

		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);

		}

		for (int i = 1; i <= n; i++) {
			ans = Math.max(ans, dp[i]);
		}

		System.out.println(ans);
	}

}