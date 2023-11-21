import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, ans;
	static int[][] forest;
	static int[][] dp;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		forest = new int[n][n];
		dp = new int[n][n];

		ans = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				forest[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ans = Math.max(ans, dfs(i, j));
			}
		}

		System.out.println(ans);
	}

	private static int dfs(int nowi, int nowj) {

		if (dp[nowi][nowj] != 0)
			return dp[nowi][nowj];

		dp[nowi][nowj] = 1;

		for (int d = 0; d < 4; d++) {
			int nexti = nowi + di[d];
			int nextj = nowj + dj[d];

			if (nexti < 0 || nexti >= n || nextj < 0 || nextj >= n)
				continue;

			if (forest[nowi][nowj] >= forest[nexti][nextj]) {

				continue;
			}

			dp[nowi][nowj] = Math.max(dp[nowi][nowj], dfs(nexti, nextj) + 1);

		}

		return dp[nowi][nowj];

	}

}