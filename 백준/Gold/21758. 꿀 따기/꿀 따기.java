import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, max;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		int sum = 0;
		max = 0;

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
		}

		endHoneyPot(sum);
		startHoneyPot(sum);
		moveHoneyPot(sum);

		System.out.println(max);

	}

	public static void endHoneyPot(int sum) {

		sum -= arr[0];

		int a = sum;

		for (int i = 1; i < N - 1; i++) {
			sum -= arr[i];
			max = Math.max(max, sum + a - arr[i]);
		}

	}

	public static void startHoneyPot(int sum) {

		sum -= arr[N - 1];

		int a = sum;

		for (int i = N - 2; i > 0; i--) {
			sum -= arr[i];
			max = Math.max(max, sum + a - arr[i]);
		}

	}

	public static void moveHoneyPot(int sum) {

		int a = 0;
		int b = sum - arr[N - 1];

		for (int i = 1; i < N - 1; i++) {
			a += arr[i];
			b -= arr[i - 1];
			max = Math.max(max, a + b);
		}

	}

}