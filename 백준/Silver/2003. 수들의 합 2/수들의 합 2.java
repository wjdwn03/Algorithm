import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] a = new int[N];
		int[] sum = new int[N + 1];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			sum[i + 1] = sum[i] + a[i];
		}

		int start = 0, end = 1, cnt = 0;

		while (end <= N) {
			int num = sum[end] - sum[start];
			if (num == M) {
				cnt++;
				end++;
			} else if (num < M) {
				end++;
			} else {
				start++;
			}
		}

		System.out.println(cnt);

	}

}