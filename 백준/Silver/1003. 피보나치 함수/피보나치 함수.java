import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		arr = new int[41][2];

		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());

			arr[0][0] = 1;
			arr[0][1] = 0;
			arr[1][0] = 0;
			arr[1][1] = 1;

			dfs(N);

			sb.append(arr[N][0]).append(" ").append(arr[N][1]).append("\n");
		}

		System.out.println(sb.toString());

	}

	private static int[] dfs(int num) {

		if (arr[num][0] == 0 && arr[num][1] == 0 && num > 1) {
			arr[num][0] = dfs(num - 1)[0] + dfs(num - 2)[0];
			arr[num][1] = dfs(num - 1)[1] + dfs(num - 2)[1];
		}

		return arr[num];

	}

}