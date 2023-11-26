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

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = M - 1; j >= 0; j--) {
				sb.append(input.charAt(j));
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

}
