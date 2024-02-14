import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	static long[][] origin = { { 1L, 1L }, { 1L, 0L } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		long n = Long.parseLong(br.readLine());

		long[][] arr = { { 1L, 1L }, { 1L, 0L } };

		long[][] ans = pow(arr, n - 1);

		sb.append(ans[0][0]);

		System.out.println(sb.toString());

	}

	private static long[][] pow(long[][] arr, long n) {

		if (n < 2) {
			return arr;
		}

		long[][] result = pow(arr, n / 2);

		result = multiply(result, result);

		if (n % 2 == 1L) {
			result = multiply(result, origin);
		}

		return result;
	}

	private static long[][] multiply(long[][] arr1, long[][] arr2) {

		long[][] result = new long[2][2];

		result[0][0] = (arr1[0][0] * arr2[0][0] + arr1[0][1] * arr2[1][0]) % 1_000_000_007;
		result[0][1] = (arr1[0][0] * arr2[0][1] + arr1[0][1] * arr2[1][1]) % 1_000_000_007;
		result[1][0] = (arr1[1][0] * arr2[0][0] + arr1[1][1] * arr2[1][0]) % 1_000_000_007;
		result[1][1] = (arr1[1][0] * arr2[0][1] + arr1[1][1] * arr2[1][1]) % 1_000_000_007;

		return result;
	}

}