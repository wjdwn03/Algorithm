import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		long A = Long.parseLong(st.nextToken());
		long D = Long.parseLong(st.nextToken());

		long X = 0, next = A;

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int sound = Integer.parseInt(st.nextToken());

			if (next == sound) {
				next += D;
				X++;
			}

		}

		System.out.println(X);
	}

}