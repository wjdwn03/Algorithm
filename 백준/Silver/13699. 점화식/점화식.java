import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static long[] arr;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new long[N + 1];

		arr[0] = 1L;

		long ans = dfs(N);

		System.out.println(ans);
	}

	private static long dfs(int n) {

		if (arr[n] != 0)
			return arr[n];

		for (int i = 0; i < n; i++) {
			arr[n] += (dfs(i) * dfs(n - 1 - i));
		}

		return arr[n];

	}

}