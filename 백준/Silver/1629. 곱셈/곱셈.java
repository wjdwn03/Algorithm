import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	static long A, B, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());

		long ans = 0;

		if (C == 1 || A == C) {
			ans = 0;
		} else if (A == 1 || B == 1) {
			ans = A % C;
		} else {
			ans = pow(A, B);
		}

		System.out.println(ans);
	}

	private static long pow(long A, long B) {

		if (B == 1) {
			return A % C;
		}

		long num = pow(A, B / 2);

		if (B % 2 == 1) {
			return (num * num % C) * A % C;
		}
		return num * num % C;
	}

}