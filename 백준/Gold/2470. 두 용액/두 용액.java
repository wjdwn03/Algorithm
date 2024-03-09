import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, ans;
	static int[] water;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		water = new int[2]; // 두 용액을 저장할 배열
		arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} // tail input

		Arrays.sort(arr);

		ans = 2_000_000_000;
		water[0] = arr[0];
		water[1] = arr[N - 1];

		if (N > 2) {
			int head = 0;
			int tail = N - 1;

			while (head < tail) {

				int sum = arr[head] + arr[tail];

				if (Math.abs(sum) < ans) {
					ans = Math.abs(sum);
					water[0] = arr[head];
					water[1] = arr[tail];

					if (ans == 0)
						break;
				}

				if (sum < 0)
					head++;
				else
					tail--;
			} // end while

		} // end if

		System.out.println(water[0] + " " + water[1]);
	}

}