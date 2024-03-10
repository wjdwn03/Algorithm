import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static long time;
	static long[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		time = 0L;

		arr = new long[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}

		Arrays.sort(arr);

		findMinTime();

		System.out.println(time);
	}

	private static void findMinTime() {

		long left = 1L;

		long right = arr[0] * M;
		long mid = 0L;
		long cnt = 0L;
		time = right;

		while (left <= right) {
			cnt = 0;
			mid = (left + right) / 2;

			for (int i = 0; i < N; i++) {
				cnt += mid / arr[i];
			}

			if (cnt >= M) {
				time = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

	}

}