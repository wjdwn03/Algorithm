import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int max = 0;
		int out = Integer.parseInt(st.nextToken());
		int in = Integer.parseInt(st.nextToken());
		int sum = 0;

		while (in > 0) {
			sum -= out;
			sum += in;

			max = Math.max(max, sum);

			st = new StringTokenizer(br.readLine());

			out = Integer.parseInt(st.nextToken());
			in = Integer.parseInt(st.nextToken());
		}

		System.out.println(max);

	}

}