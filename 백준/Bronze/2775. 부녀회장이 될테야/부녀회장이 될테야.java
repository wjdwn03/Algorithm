import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		arr = new int[15][15];

		for (int i = 1; i < 15; i++) {
			arr[0][i] = i;
		}

		int T = Integer.parseInt(br.readLine());

		int k, n;

		for (int t = 0; t < T; t++) {
			k = Integer.parseInt(br.readLine());
			n = Integer.parseInt(br.readLine());

			sb.append(getPeople(k, n)).append("\n");
		}
		System.out.println(sb.toString());

	}

	private static int getPeople(int k, int n) {

		if (n == 0)
			return 0;

		if (arr[k][n] != 0)
			return arr[k][n];

		arr[k][n] = getPeople(k, n - 1) + getPeople(k - 1, n);

		return arr[k][n];
	}

}