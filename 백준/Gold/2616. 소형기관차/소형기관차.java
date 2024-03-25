import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, ans;
	static int[] arr;
	static int[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		arr = new int[N + 1];

		st = new StringTokenizer(br.readLine());

		// 누적합
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken()) + arr[i - 1];
		}

		M = Integer.parseInt(br.readLine()); // 최대로 끌 수 있는 객차의 수
		ans = 0;

		dp = new int[4][N + 1];

		for (int i = 1; i < 4; i++) {
			for (int j = i * M; j <= N; j++) {
				dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - M] + arr[j] - arr[j - M]);
			}
		}

		System.out.println(dp[3][N]);
	}

}