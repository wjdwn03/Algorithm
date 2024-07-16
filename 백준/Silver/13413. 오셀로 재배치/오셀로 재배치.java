import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());

			char[] a = br.readLine().toCharArray();
			char[] b = br.readLine().toCharArray();

			int W = 0;
			int B = 0;

			for (int i = 0; i < N; i++) {
				if (a[i] != b[i]) {
					if (a[i] == 'W') {
						W++;
					} else {
						B++;
					}
				}
			}

			sb.append(Math.min(W, B) + (int) Math.abs(W - B));

			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

}