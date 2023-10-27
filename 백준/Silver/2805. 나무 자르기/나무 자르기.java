import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M, max;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} // end input

		Arrays.sort(arr);

		int start = 0; // 이분 탐색 제일 처음 start값
		int end = arr[N - 1]; // 이분 탐색 제일 처음 end값
		int mid = (start + end) / 2;
		long sum = 0L; // 절단한 나무 길이 저장할 변수
		max = 0;

		while (start <= end) {

			mid = (start + end) / 2;

			sum = 0L;

			for (int i = 0; i < N; i++) {
				if (arr[i] <= mid)
					continue;
				sum += (long) arr[i] - mid;
				if (sum > M)
					break;
			}

			if (sum >= M) {
				max = Math.max(max, mid);
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		System.out.println(max);

	}

}