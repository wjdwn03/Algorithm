import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int cnt = 2;
		String six = "666";
		String part = "1";
		String num = six;

		int back = 0;

		while (cnt <= N) {

			int idx = -1;

//			part 끝이 6인지 검사 
//			항상 part 바로 뒤에 "666"이 붙기 때문에 part의 일의 자리가 6이면
			if (part.charAt(part.length() - 1) == '6') {

				// part의 끝에서부터 6이 연달아 몇 개 있는지 확인
				for (int i = part.length() - 1; i >= 0; i--) {
					if (part.charAt(i) != '6') {
						idx = i + 1;
						break;
					}
				}

				// 만약 part가 전부 6으로만 이루어져 있으면 idx는 갱신되지 않았을 것이다.
				if (idx == -1)
					idx = 0;

			}

			// part 일의 자리가 6이 아닌 경우
			if (idx == -1) {
				num = part + six;
				cnt++;
			}
			// part 일의 자리가 6인 경우
			else {

				// part 끝에서부터 6의 개수 길이 만큼 "666" 뒤에 붙여줘야 한다.
				int tmp = (int) Math.pow(10, part.length() - idx);

				// cnt를 증가하다가 cnt를 충족하면 break
				for (back = 0; back < tmp; back++) {

					cnt++;

					if (cnt > N) {
						break;
					}

				}

				num = part.substring(0, idx) + six;

				int len = String.valueOf(back).length();

				for (int j = part.length() - idx - len; j > 0; j--) {
					num += "0";
				}

				num += String.valueOf(back);

			} // end else

			part = String.valueOf(Integer.parseInt(part) + 1);

		} // end while

		System.out.println(num);
	}

}