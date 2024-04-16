import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String N = br.readLine();
		int origin = Integer.parseInt(N);

		String num = N;

		int cnt = 0;

		while (true) {
			if (num.length() < 2)
				num = "0" + num;

			int sum = 0;
			int len = num.length();

			for (int i = 0; i < len; i++) {
				sum += num.charAt(i) - '0';
			}

			num = num.substring(len - 1, len) + String.valueOf(sum % 10);

			cnt++;

			if (Integer.parseInt(num) == origin)
				break;
		}

		System.out.println(cnt);
	}

}