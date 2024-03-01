import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static long[] arr;
	static int min, N, S;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		arr = new long[N + 1];
		min = 100_000;

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			arr[i] = arr[i - 1] + Long.parseLong(st.nextToken());
		}

		int start = 0, end = 1;

		while (end <= N) {
			if (arr[end] - arr[start] < S || start >= end) {
				end++;
			} else if (arr[end] - arr[start] >= S) {
				min = Math.min(min, end - start);
				start++;
			}
		}

		end = end > N ? N : end;

		for (int i = start; i < N; i++) {
			if (arr[end] - arr[start] >= S) {
				min = Math.min(min, end - i);
			}
		}

		min = min == 100000 ? 0 : min;

		System.out.println(min);
	}

}