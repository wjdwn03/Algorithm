import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] input = br.readLine().split(":");

		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		int min = Math.min(n, m);

		for (int i = min; i > 0; i--) {
			if (n % i == 0 && m % i == 0) {
				sb.append(n / i).append(":").append(m / i);
				break;
			}
		}

		System.out.println(sb.toString());
	}

}