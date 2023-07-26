import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder minSb = new StringBuilder(); // 최솟값 저장
		StringBuilder maxSb = new StringBuilder(); // 최댓값 저장

		String mk = br.readLine(); // input

		// 길이가 3,000까지 되기 때문에 long으로 다 표현 못할 수 있음.
		BigInteger max = BigInteger.ONE;
		BigInteger min = BigInteger.ONE;

		BigInteger ten = new BigInteger("10"); // 십진수로 변환할 때 필요함.
		BigInteger five = new BigInteger("5"); // 십진수로 변환할 때 필요함.

		int mCnt = 0;

		for (int i = 0; i < mk.length(); i++) {

			char now = mk.charAt(i);

			if (now == 'M') {

				mCnt++;

				// 현재가 M인데 문자열 끝까지 온 경우
				if (i == mk.length() - 1) {

					// 10^(mCnt-1)한 게 최솟값이고
					min = ten.pow(mCnt - 1);

					minSb.append(min);

					// mCnt만큼 1을 붙인게 최댓값이다.
					for (int j = 0; j < mCnt; j++) {
						maxSb.append("1");
					}

					break;
				}
			} // end if

			// now == 'K'
			else {

				max = ten.pow(mCnt).multiply(five); // 10^mCnt * 5

				// M의 개수가 0인 경우 무조건 5가 나올 수밖에 없으므로 min = max이다.
				if (mCnt == 0) {
					min = max;
				} else {
					min = ten.pow(mCnt).add(five); // "10^mCnt + 5" -> 이건 "10^(mCnt-1)" 뒤에 5를 붙인 것과 같다.
				}

				mCnt = 0;

				minSb.append(min);
				maxSb.append(max);
			} // end else

		} // end for

		System.out.println(maxSb);
		System.out.println(minSb);

	}

}