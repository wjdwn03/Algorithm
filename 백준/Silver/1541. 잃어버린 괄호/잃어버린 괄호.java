import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();

		boolean minus = false; // '-'가 나온 적 있는지 확인
		String num = ""; // 숫자인 문자열만 더할 변수
		int ans = 0; // 정답
		int realNum = 0; // 문자열 num을 int로 변환한 변수

		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == '+' || s.charAt(i) == '-') {

				realNum = changeToInt(num);

				ans = calculate(minus, realNum, ans);

				// '-'인 경우 ans 해당 조건문이 ans 계산하는 코드 다음에 와야한다.
				// '-'는 그 다음에 오는 숫자부터 적용되기 때문이다.
				if (s.charAt(i) == '-') {
					minus = true;
				}

				num = "";

			}

			else {

				num += s.charAt(i);
			}

		}

		// 마지막에 항상 숫자로 끝나기 때문에 마지막 숫자도 계산을 해줘야 한다.
		realNum = changeToInt(num);

		ans = calculate(minus, realNum, ans);

		System.out.println(ans);
	}

	private static int calculate(boolean minus, int realNum, int ans) {

		if (minus) {
			ans -= realNum;
		} else {
			ans += realNum;
		}

		return ans;
	}

	private static int changeToInt(String num) {

		int result = 0;
		int b = num.length() - 1;

		for (int i = 0; i < num.length(); i++) {
			if (b != 0) {
				result += (num.charAt(i) - '0') * Math.pow(10, b--);
			} else {
				result += num.charAt(i) - '0';
			}
		}
		return result;
	}

}