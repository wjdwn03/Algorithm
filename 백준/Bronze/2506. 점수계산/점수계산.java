import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());

		int score = 0, sum = 0;

		for (int i = 0; i < N; i++) {
			int result = Integer.parseInt(st.nextToken());

			if (result == 0) {
				score = 0;
				continue;
			}

			sum += ++score;
		}

		System.out.println(sum);

	}

}