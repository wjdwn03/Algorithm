import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static long[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		arr = new long[101];

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());

			arr[0] = 1;
			arr[1] = 1;
			arr[2] = 1;
			arr[3] = 2;
			arr[4] = 2;
			arr[5] = 3;

			dfs(N - 1);

			sb.append(arr[N - 1]).append("\n");
		}

		System.out.println(sb.toString());
	}

	private static long dfs(int n) {

		if (arr[n] != 0 || n < 5) {
			return arr[n];
		}

		arr[n] = dfs(n - 1) + dfs(n - 5);

		return arr[n];

	}

}