import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int five = n / 5;
		int two = n % 5 / 2;

		int cnt = Integer.MAX_VALUE;

		while (five >= 0) {

			if (five * 5 + two * 2 == n) {
				cnt = Math.min(cnt, five + two);
				break;
			}
			five--;
			if (five == 0) {
				two = n / 2;
			} else {
				two = (n - five * 5) / 2;
			}

		}

		if (cnt == Integer.MAX_VALUE)
			cnt = -1;

		System.out.println(cnt);

	}

}