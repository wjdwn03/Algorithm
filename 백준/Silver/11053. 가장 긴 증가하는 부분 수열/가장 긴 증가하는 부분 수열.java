import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, ans;
	static int[] arr;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new int[N];
		dp = new int[N];
		ans = -1;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			int result = dfs(i);
			ans = Math.max(ans, result);
		}

		System.out.println(ans);
	}

	private static int dfs(int idx) {

		if (dp[idx] == 0) {

			dp[idx] = 1;

			for (int i = idx - 1; i >= 0; i--) {
				if (arr[i] < arr[idx]) {
					dp[idx] = Math.max(dp[idx], dfs(i) + 1);
				}
			}

		}
		return dp[idx];

	}

}