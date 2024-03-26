import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {

	static int[][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		dp = new int[101][101][101];
		dp[0][0][0] = 1;

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		while (a != -1 || b != -1 || c != -1) {

			sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ");

			// a, b, c가 음수가 올 수 있기 때문에 인덱스로 활용하기 위해 +50을 해줌.
			sb.append(dfs(a + 50, b + 50, c + 50)).append("\n");

			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
		}

		System.out.println(sb.toString());
	}

	private static int dfs(int a, int b, int c) {

		if (a <= 50 || b <= 50 || c <= 50)
			return dp[a][b][c] = 1;

		if (dp[a][b][c] != 0)
			return dp[a][b][c];

		else if (a > 70 || b > 70 || c > 70)
			return dp[a][b][c] = dfs(70, 70, 70);

		else if (a < b && b < c)
			return dp[a][b][c] = dfs(a, b, c - 1) + dfs(a, b - 1, c - 1) - dfs(a, b - 1, c);

		else
			return dp[a][b][c] = dfs(a - 1, b, c) + dfs(a - 1, b - 1, c) + dfs(a - 1, b, c - 1)
					- dfs(a - 1, b - 1, c - 1);
	}

}