import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int L = Integer.parseInt(br.readLine());
		String str = br.readLine();

		BigInteger ans = new BigInteger("0");

		for (int i = 0; i < L; i++) {
			BigInteger now = new BigInteger(String.valueOf((str.charAt(i) - 'a' + 1) * (int) Math.pow(31, i)));

			ans = ans.add(now);
		}

		System.out.println(ans.toString());
	}

}