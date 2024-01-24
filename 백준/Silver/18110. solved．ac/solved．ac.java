import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		long avg = Math.round(n * 0.15); // 절사평균

		long[] arr = new long[n];
		long sum = 0;

		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(br.readLine());
			sum += arr[i];
		}

		Arrays.sort(arr);

		for (int i = 0; i < avg; i++) {
			sum -= arr[i];
			sum -= arr[n - i - 1];
		}

		System.out.println(Math.round((double) sum / (n - avg * 2)));

	}

}