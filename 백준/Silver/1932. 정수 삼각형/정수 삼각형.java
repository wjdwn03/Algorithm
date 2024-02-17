import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, ans;
	static int[][] arr;
	static int[][] weight;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		weight = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}

			if (i == N - 1) {
				weight[i] = Arrays.copyOfRange(arr[i], 0, N);
			}

		} // end input

		ans = dfs(0, 0);

		System.out.println(ans);
	}

	private static int dfs(int nowi, int nowj) {

		if (nowi == N - 1) {
			return arr[nowi][nowj];
		}

		if (weight[nowi][nowj] == 0) {

			weight[nowi][nowj] = arr[nowi][nowj] + Math.max(dfs(nowi + 1, nowj), dfs(nowi + 1, nowj + 1));
		}

		return weight[nowi][nowj];
	}

}