import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());

			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());

			int floor = N % H;
			int ho = N / H + 1;

			if (floor == 0) {
				floor = H;
				ho--;
			}

			sb.append(floor);

			if (ho < 10) {
				sb.append("0");
			}

			sb.append(ho).append("\n");

		}

		System.out.println(sb.toString());
	}

}