import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int K, N;
	static long ans;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		ans = 0L;
		arr = new int[K];

		long start = 1;
		long end = 0;
		long mid = 0;
		long len = 0;

		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (end < arr[i])
				end = arr[i];
		} // end input

		while (start <= end) {

			mid = (start + end) / 2;

			len = 0;

			// 만들 수 있는 랜선 개수 세기
			for (int i = 0; i < K; i++) {
				len += (long) arr[i] / mid;
			}

			if (len < N) {
				end = mid - 1;
			} else {
				ans = mid;
				start = mid + 1;
			}
		}

		System.out.println(ans);
	}

}