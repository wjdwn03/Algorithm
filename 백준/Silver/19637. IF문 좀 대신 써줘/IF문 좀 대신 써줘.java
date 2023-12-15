import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		String[] nickname = new String[N];
		int[] power = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			nickname[i] = st.nextToken();
			power[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = N - 1;
		int mid = 0;
		int now = 0;

		for (int i = 0; i < M; i++) {
			now = Integer.parseInt(br.readLine());

			start = 0;
			end = N - 1;

			while (start <= end) {

				mid = (start + end) / 2;

				if (now <= power[mid]) {
					end = mid - 1;
				} else if (now > power[mid]) {
					start = mid + 1;
				}
			}
			sb.append(nickname[start]).append("\n");

		}

		System.out.println(sb.toString());

	}

}