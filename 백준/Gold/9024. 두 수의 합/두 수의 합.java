import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static int N, K, min;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			min = 200_000_000;

			arr = new int[N];

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr);

			sb.append(findMin()).append("\n");
		}

		System.out.println(sb.toString());
	}

	private static int findMin() {

		int left = 0, right = N - 1, cnt = 0;

		while (left < right) {
			int diff = K - (arr[left] + arr[right]);
			int absDiff = Math.abs(diff);

			// min 갱신해야 하는 경우
			if (min >= absDiff) {
				if (min == absDiff) {
					cnt++;
				} else {
					min = absDiff;
					cnt = 1;
				}
			}
            
			if (diff < 0) {
				right--;
			} else {
				left++;
			}
		} // end while

		return cnt;

	}

}