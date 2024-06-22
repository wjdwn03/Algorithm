import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int ans = 0;

		for (int i = 0; i < N; i++) {
			int l = 0;
			int r = N - 1;

			while (l < r) {
				if (l == i) {
					l++;
					continue;
				} else if (r == i) {
					r--;
					continue;
				}

				int sum = arr[l] + arr[r];

				if (sum == arr[i]) {
					ans++;
					break; // 동일한 조합을 중복해서 셀 수 있기 때문에 break 한다.
				} else if (sum < arr[i]) {
					l++;
				} else {
					r--;
				}
			}
		}

		System.out.println(ans);
	}

}