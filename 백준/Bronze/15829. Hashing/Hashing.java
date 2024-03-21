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
		BigInteger hash = new BigInteger("1");

		for (int i = 0; i < L; i++) {

			ans = ans.add(BigInteger.valueOf(str.charAt(i) - 'a' + 1).multiply(hash));
			hash = hash.multiply(BigInteger.valueOf(31));
			ans = ans.mod(BigInteger.valueOf(1234567891L));
		}

		System.out.println(ans.toString());
	}

}