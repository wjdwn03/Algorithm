import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		long n = Long.parseLong(st.nextToken());
		long m = Long.parseLong(st.nextToken());

		long five = countZero(n, 5) - countZero(n - m, 5) - countZero(m, 5);
		long two = countZero(n, 2) - countZero(n - m, 2) - countZero(m, 2);

		// 팩토리얼 0의 개수는 하나의 숫자에 대한 팩토리얼을 구하는 것이기 때문에 무조건 2가 포함되어 있다.
		// 그래서 5로 나는 것만 구해도 괜찮다.
		// 조합은 공식으로 인해 2가 포함되지 않는 경우도 있기 때문에 5와 2 둘 다 나눠서 적은 것을 구해야 한다. ex) 5C1
		long ans = Math.min(five, two);

		System.out.println(ans);
	}

	public static long countZero(long num, int divideNum) {

		long cnt = 0;

		while (num >= divideNum) {
			cnt += num / divideNum;

			num /= divideNum;
		}

		return cnt;

	}

}