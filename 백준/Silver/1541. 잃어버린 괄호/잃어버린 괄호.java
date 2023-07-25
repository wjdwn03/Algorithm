import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();

		boolean minus = false; // '-'가 나온 적 있는지 확인
		int ans = 0; // 정답
		int startIdx = 0;
		int realNum = 0; // 문자열 num을 int로 변환한 변수

		for (int i = 0; i <= s.length(); i++) {

			if (i == s.length() || s.charAt(i) == '+' || s.charAt(i) == '-') {

				realNum = Integer.parseInt(s.substring(startIdx, i));
				ans = calculate(minus, realNum, ans);

				startIdx = i + 1;

				// '-'인 경우 ans 해당 조건문이 ans 계산하는 코드 다음에 와야한다.
				// '-'는 그 다음에 오는 숫자부터 적용되기 때문이다.
				if (i != s.length() && s.charAt(i) == '-') {
					minus = true;
				}
			}
		}

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

}