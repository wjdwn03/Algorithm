import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n + 1][m + 1];
		int[][] ans = new int[n + 1][m + 1];

		int max = 0;

		for (int i = 1; i <= n; i++) {
			String input = br.readLine();
			for (int j = 1; j <= m; j++) {
				arr[i][j] = input.charAt(j - 1) - '0';
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {

				if (arr[i - 1][j - 1] == arr[i - 1][j] && arr[i - 1][j] == arr[i][j - 1]) {
					ans[i][j] = Math.min(ans[i - 1][j - 1], Math.min(ans[i - 1][j], ans[i][j - 1])) + arr[i][j];
				} else {
					ans[i][j] = arr[i][j];
				}

				max = Math.max(max, ans[i][j]);
			}
		}

		System.out.println(max * max);
	}

}