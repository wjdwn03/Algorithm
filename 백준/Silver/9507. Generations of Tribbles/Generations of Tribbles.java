import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static long[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		arr = new long[68];

		arr[0] = 1L;
		arr[1] = 1L;
		arr[2] = 2L;
		arr[3] = 4L;

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());

			long ans = fibo(n);

			sb.append(ans).append("\n");
		}

		System.out.println(sb.toString());

	}

	private static long fibo(int n) {

		if (n < 2)
			return 1L;

		if (arr[n] != 0)
			return arr[n];

		arr[n] = fibo(n - 1) + fibo(n - 2) + fibo(n - 3) + fibo(n - 4);

		return arr[n];
	}

}