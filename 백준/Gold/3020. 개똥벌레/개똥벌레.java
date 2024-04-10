import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, H, min, cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		int[] up = new int[N / 2];
		int[] down = new int[N / 2];

		for (int i = 0; i < N / 2; i++) {
			int d = Integer.parseInt(br.readLine());
			int u = Integer.parseInt(br.readLine());

			down[i] = d;
			up[i] = u;
		}

		Arrays.sort(down);
		Arrays.sort(up);

		min = N;
		cnt = 0;

		for (int i = 1; i <= H; i++) {
			int conflict = binarySearch(0, N / 2, i, down) + binarySearch(0, N / 2, H - i + 1, up);
			if (min == conflict) {
				cnt++;
			} else if (min > conflict) {
				min = conflict;
				cnt = 1;
			}
		}

		sb.append(min).append(" ").append(cnt);
		System.out.println(sb.toString());
	}

	private static int binarySearch(int start, int end, int h, int[] arr) {

		while (start < end) {
			int mid = (start + end) / 2;

			if (arr[mid] >= h) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return N / 2 - end;
	}

}