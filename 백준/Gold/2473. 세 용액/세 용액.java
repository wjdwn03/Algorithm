import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static long min, waterA, waterB, waterC;
	static long[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		arr = new long[N];
		min = 3000000001L;
		waterA = waterB = waterC = 0L;

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(arr);

		for (int i = 0; i <= N - 3; i++) {
			int l = i + 1;
			int r = N - 1;

			while (l < r) {
				long sum = arr[i] + arr[l] + arr[r];

				if (Math.abs(sum - 0) < min) {
					waterA = arr[i];
					waterB = arr[l];
					waterC = arr[r];
					min = Math.abs(sum - 0);

					if (min == 0)
						break;
				}

				if (sum < 0) {
					l++;
				} else {
					r--;
				}
			}
		}

		sb.append(waterA).append(" ").append(waterB).append(" ").append(waterC);

		System.out.println(sb.toString());

	}
}