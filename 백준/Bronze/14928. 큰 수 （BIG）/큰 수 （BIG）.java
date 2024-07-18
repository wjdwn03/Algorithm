import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		long ans = 0L;

		for (int i = 0; i < input.length(); i++) {
			ans = (ans * 10 + (input.charAt(i) - '0')) % 20000303;
		}

		System.out.println(ans);
	}

}