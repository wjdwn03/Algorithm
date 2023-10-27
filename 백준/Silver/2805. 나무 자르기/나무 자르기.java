import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		max = 0;

		st = new StringTokenizer(br.readLine());

		int start = 0; // 이분 탐색 제일 처음 start값
		int end = 0; // 이분 탐색 제일 처음 end값

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (end < arr[i])
				end = arr[i];
		} // end input

		long sum = 0L; // 절단한 나무 길이 저장할 변수
		int mid = (start + end) / 2;

		while (start <= end) {

			mid = (start + end) / 2;

			sum = 0L;

			// 가져갈 수 있는 나무 길이 확인
			for (int i = 0; i < N; i++) {
				if (arr[i] <= mid)
					continue;
				sum += (long) arr[i] - mid;
				if (sum > M)
					break;
			}

			if (sum >= M) {
				max = Math.max(mid, mid);
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		System.out.println(max);

	}

}