import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		long w = Long.parseLong(st.nextToken());

		int[] arr = new int[n];
		arr[0] = Integer.parseInt(br.readLine());

		long coin = 0;
		boolean buy = false;

		for (int i = 1; i < n; i++) {

			arr[i] = Integer.parseInt(br.readLine());

			if (arr[i - 1] < arr[i] && !buy) {
				coin = w / arr[i - 1];
				w -= arr[i - 1] * coin;
				buy = true;
			}

			if (arr[i - 1] > arr[i] && buy) {
				w += arr[i - 1] * coin;
				coin = 0;
				buy = false;
			}
		} // end for i

		if (buy && coin != 0) {
			w += arr[n - 1] * coin;
		}

		System.out.println(w);

	}
}