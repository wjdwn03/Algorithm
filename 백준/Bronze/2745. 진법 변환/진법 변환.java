import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String N = st.nextToken();

		int B = Integer.parseInt(st.nextToken());

		int size = N.length();
		int sum = 0;

		int idx = 0;

		// N의 1의 자리부터 계산한다.
		for (int i = size - 1; i >= 0; i--) {
			int now = N.charAt(i) - '0';

			if (now > 9) {
				now -= 7; // 문제에서 A는 10인데 'A' - '0'을 해보면 17이 나온다. 그래서 7을 빼줌.
			}

			sum += (int) Math.pow(B, idx++) * now;

		}

		System.out.println(sum);
	}

}