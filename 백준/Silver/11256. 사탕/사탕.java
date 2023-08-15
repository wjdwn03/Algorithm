import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());

			int J = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());

			int[] arr = new int[N];

			int sum = 0;
			int cnt = 0;
			boolean check = true;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());

				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				arr[i] = r * c;

			}

			Arrays.sort(arr);

			for (int i = N - 1; i >= 0; i--) {

				sum += arr[i];

				cnt++;

				if (sum >= J) {
					break;
				}
			}

			sb.append(cnt).append("\n");
		} // end for t

		System.out.println(sb.toString());
	}

}