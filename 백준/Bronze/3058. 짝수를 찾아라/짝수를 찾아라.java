import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int min = 101;
			int sum = 0;

			while (st.hasMoreTokens()) {
				int now = Integer.parseInt(st.nextToken());
				if (now % 2 == 0) {
					sum += now;
					min = Math.min(min, now);
				}
			}

			sb.append(sum).append(" ").append(min).append("\n");
		}

		System.out.println(sb.toString());
	}

}