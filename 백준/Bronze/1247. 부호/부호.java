import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 3; i++) {
			int N = Integer.parseInt(br.readLine());

			BigInteger sum = new BigInteger("0");

			for (int n = 0; n < N; n++) {
				BigInteger num = new BigInteger(br.readLine());
				sum = sum.add(num);
			}
			int result = sum.compareTo(new BigInteger("0"));

			if (result == 0) {
				sb.append("0");
			} else if (result == -1) {
				sb.append("-");
			} else {
				sb.append("+");
			}
			sb.append("\n");

		}

		System.out.println(sb.toString());
	}

}