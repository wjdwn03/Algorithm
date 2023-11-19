import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int ans;
	static boolean isLeap;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int tYear = Integer.parseInt(st.nextToken()); // 오늘 연도
		int tMonth = Integer.parseInt(st.nextToken()); // 오늘 월
		int tDay = Integer.parseInt(st.nextToken()); // 오늘 일

		st = new StringTokenizer(br.readLine());

		int dYear = Integer.parseInt(st.nextToken()); // d-day 연도
		int dMonth = Integer.parseInt(st.nextToken()); // d-day 월
		int dDay = Integer.parseInt(st.nextToken()); // d-day 일

		ans = 0;
		isLeap = checkLeap(tYear);

		// 천 년 이상 차이나는 경우
		if (dYear - tYear > 1000
				|| (dYear - tYear == 1000 && ((tMonth < dMonth) || (tMonth == dMonth && tDay <= dDay)))) {
			sb.append("gg");
		} else {

			// 일 먼저 계산하자.
			if (tDay <= dDay) {
				ans = dDay - tDay;
			} else {
				ans = getDay(tMonth) - tDay + dDay;
				tMonth++;

				if (tMonth > 12) {
					tMonth = 1;
					tYear++;
					isLeap = checkLeap(tYear);
				}
			}

			// 월 계산
			while (tMonth != dMonth) {
				ans += getDay(tMonth);

				tMonth++;

				if (tMonth > 12) {
					tMonth = 1;
					tYear++;
					isLeap = checkLeap(tYear);
				}
			}

			// 년 계산
			for (int year = tYear; year < dYear; year++) {

				if (dMonth > 2) {
					isLeap = checkLeap(year + 1);

				} else {
					isLeap = checkLeap(year);
				}

				if (isLeap)
					ans += 366;
				else
					ans += 365;

			}
			sb.append("D-").append(ans);
		} // end else

		System.out.println(sb.toString());

	}

	private static int getDay(int month) {

		switch (month) {
		case 2:
			if (isLeap)
				return 29;
			else
				return 28;
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return 31;
		default:
			return 30;
		}
	}

	private static boolean checkLeap(int year) {

		if (year % 4 == 0) {
			if (year % 100 == 0) {

				// 윤년
				if (year % 400 == 0) {
					return true;
				}

				// 평년
				return false;
			}
			return true;
		}

		return false;

	}

}