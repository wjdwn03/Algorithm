import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] map;
	static int[][] dp;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];
		dp = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.fill(dp[i], -1);
		}

		System.out.println(dfs(1, 1));

	}

	private static int dfs(int nowi, int nowj) {

		if (nowi == N && nowj == M)
			return 1;
		
		if (dp[nowi][nowj] != -1)
			return dp[nowi][nowj];

		
		dp[nowi][nowj] = 0;
		
		for (int d = 0; d < 4; d++) {
			int nexti = nowi + di[d];
			int nextj = nowj + dj[d];

			if (nexti < 1 || nexti > N || nextj < 1 || nextj > M )
				continue;

			if(map[nowi][nowj] > map[nexti][nextj]) {
				dp[nowi][nowj] += dfs(nexti, nextj);
			}

		}

		return dp[nowi][nowj];

	}

}