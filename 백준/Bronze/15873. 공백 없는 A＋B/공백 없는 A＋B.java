import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();

		int A = 0, B = 0;

		int len = input.length();

		if (len == 2) {
			A = input.charAt(0) - '0';
			B = input.charAt(1) - '0';
		} else if (len == 3) {
			if (input.charAt(1) == '0') {
				A = Integer.parseInt(input.substring(0, 2));
				B = input.charAt(2) - '0';
			} else {
				A = input.charAt(0) - '0';
				B = Integer.parseInt(input.substring(1, 3));
			}
		} else {
			A = Integer.parseInt(input.substring(0, 2));
			B = Integer.parseInt(input.substring(2, 4));
		}

		System.out.println(A + B);

	}

}