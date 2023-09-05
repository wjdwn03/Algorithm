import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static int T, n;
	static List<Integer> list;
	static String p;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			p = br.readLine();
			n = Integer.parseInt(br.readLine());

			String nTmp = br.readLine();

//			if (n == 0) {
//				sb.append("error").append("\n");
//			} else {

			list = new ArrayList<>();

			// 정수 배열 문자열

			// 주어진 정수배열을 "[]"를 제거하고 ","를 구분자로 쪼갠다.
			String[] num = nTmp.substring(1, nTmp.length() - 1).split(",");

			// 정수 배열로 변환
			for (int i = 0; i < n; i++) {

				list.add(Integer.parseInt(num[i]));

			} // end input

			// 정수 배열의 사이즈
			int idx = n - 1;

			// 방향(1 : 정방향, -1 : 역방향)
			int dir = 1;

			// 에러가 안 났는지 확인용 변수
			boolean check = true;

			for (int i = 0; i < p.length(); i++) {

				// R이면 방향을 반대로 바꿔줌
				if (p.charAt(i) == 'R')
					dir *= -1;

				else { // 'D'

					// idx가 0보다 작으면 삭제할 수 없으므로 에러를 출력한다.
					if (idx < 0) {
						sb.append("error").append("\n");
						check = false;
						break;
					} else {
						remove(dir, idx);
						idx--;
					}
				}
			}

			// 에러가 발생하지 않은 경우 방향에 맞게 출력한다.
			if (check) {
				sb.append("[");

				if (dir == 1) {
					int listSize = list.size();
					for (int i = 0; i < listSize; i++) {
						sb.append(list.get(i));
						if (i != listSize - 1) {
							sb.append(",");
						}
					}
				}
				// dir == -1
				else {
					for (int i = list.size() - 1; i >= 0; i--) {
						sb.append(list.get(i));
						if (i != 0) {
							sb.append(",");
						}
					}
				}

				sb.append("]").append("\n");
			} // end if
//			} // end else
		} // end for t

		System.out.println(sb.toString());

	}

	private static void remove(int dir, int idx) {

		switch (dir) {
		case 1:
			list.remove(0);
			break;
		default:
			list.remove(idx);
			break;
		}

	}

}