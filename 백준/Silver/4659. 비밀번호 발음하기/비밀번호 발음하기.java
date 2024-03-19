import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	static Set<Character> set;
	static boolean isIncluded, isAcceptable;
	static int vowelCnt, consonantCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String input = br.readLine();

		set = new HashSet<>();

		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');

		while (!input.equals("end")) {

			isIncluded = false; // 모음 포함 여부
			isAcceptable = true; // 패스워드 허용 여부
			boolean isContinuous = false; // 같은 글자가 연속으로 왔는지
			vowelCnt = 0; // 연속된 모음 개수
			consonantCnt = 0; // 연속된 자음 개수

			int size = input.length();

			for (int i = 0; i < size - 1; i++) {
				char now = input.charAt(i);
				char next = input.charAt(i + 1);

				// 같은 글자가 연속으로 온 경우
				if (now == next) {
					if (now != 'e' && now != 'o') {
						isContinuous = true;
						break;
					}
				} else {

					if (!check(now))
						break;
				}
			}

			sb.append("<").append(input).append("> is ");

			// 마지막 글자 확인
			if (!isContinuous && isAcceptable)
				check(input.charAt(size - 1));

			if (isContinuous || !isAcceptable || !isIncluded) {
				sb.append("not acceptable");
			} else {
				sb.append("acceptable");

			}

			sb.append(". \n");

			input = br.readLine();
		}

		System.out.println(sb.toString());
	}

	private static boolean check(char now) {

		// 모음인 경우
		if (set.contains(now)) {
			if (++vowelCnt >= 3) {
				isAcceptable = false;
				return false;
			}
			consonantCnt = 0;
			isIncluded = true;
		} else {
			if (++consonantCnt >= 3) {
				isAcceptable = false;
				return false;
			}
			vowelCnt = 0;
		}

		isAcceptable = true;
		return true;

	}

}