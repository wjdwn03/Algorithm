import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int L = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		int num = 1, ans = 0;

		while (L != 0 && P != 0 && V != 0) {

			if (V % P < L) {
				ans = ((V / P) * L) + (V % P);
			} else {
				ans = ((V / P) * L) + L;
			}

			sb.append("Case ").append(num).append(": ").append(ans).append("\n");

			num++;

			st = new StringTokenizer(br.readLine());

			L = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());
		}

		System.out.println(sb.toString());

	}

}