import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, C;
	static int[] home;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		home = new int[N];

		for (int i = 0; i < N; i++) {
			home[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(home);

		int start = 1;
		int end = home[N - 1] - home[0] + 1;
		int mid = (start + end) / 2;

		while (start < end) {
			mid = (start + end) / 2;

			int cnt = calculate(mid);

			if (cnt < C) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}

		System.out.println(start - 1);
	}

	private static int calculate(int dis) {

		int last = home[0];
		int cnt = 1;

		for (int i = 1; i < N; i++) {
			if (home[i] - last >= dis) {
				last = home[i];
				cnt++;
			}
		}

		return cnt;
	}

}