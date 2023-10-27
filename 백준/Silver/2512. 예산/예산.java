import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, max, ans;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		int start = 1;
		int end = 0;
		int mid = (start + end) / 2;

		max = 0; // M 이하의 가능한 한 최대의 총 예산
		ans = 0; // 예산의 최댓값

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

			if (end < arr[i])
				end = arr[i];
		}

		M = Integer.parseInt(br.readLine());

		while (start <= end) {

			mid = (start + end) / 2;

			int sum = calculate(mid);

			if (sum <= M) {
				if (max <= sum) {
					ans = Math.max(ans, mid);
				}
				start = mid + 1;
			} else {
				end = mid - 1;
			}

		}

		System.out.println(ans);

	}

	private static int calculate(int budget) {

		int sum = 0;

		for (int i = 0; i < N; i++) {
			if (budget >= arr[i])
				sum += arr[i];
			else
				sum += budget;
		}

		return sum;

	}

}