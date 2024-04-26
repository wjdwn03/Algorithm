import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		long sum = 0;

		for (int i = 0; i < N; i++) {
			long num = Long.parseLong(br.readLine());

			sum += num - 1;
		}

		System.out.println(++sum);
	}

}