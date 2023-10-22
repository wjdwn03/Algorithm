import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int cnt = 0;

			for (int i = N; i <= M; i++) {
				String num = String.valueOf(i);

				for (int j = 0; j < num.length(); j++) {
					if (num.charAt(j) == '0')
						cnt++;
				}
			}

			sb.append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}
}