import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int num = 0;
		int sum = 0;

		for (int i = 0; i < 5; i++) {
			num = Integer.parseInt(st.nextToken());

			sum += Math.pow(num, 2);
		}

		System.out.println(sum % 10);
	}

}