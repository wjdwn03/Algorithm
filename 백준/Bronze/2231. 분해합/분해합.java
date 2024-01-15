import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int ans = 0;
		int num = 0, now = 0;

		for (int i = N; i > 0; i--) {

			now = i;
			num = now;

			while (now > 0) {
				num += now % 10;

				now /= 10;
			}
			if (num == N)
				ans = i;
		}

		System.out.println(ans);
	}

}