import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		char before = str.charAt(0);

		int zero = 0;
		int one = 0;

		if (before - '0' == 0)
			zero++;
		else
			one++;

		for (int i = 1; i < str.length(); i++) {
			char now = str.charAt(i);

			if (now != before) {
				if (now - '0' == 0)
					zero++;
				else
					one++;
			}

			before = now;
		}

		System.out.println(Math.min(zero, one));
	}

}