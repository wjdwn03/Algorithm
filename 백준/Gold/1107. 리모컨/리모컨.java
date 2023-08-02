import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.xml.transform.Templates;

public class Main {

	static int Nnum, M, min;
	static String N;
	static boolean[] buttons;
	static int[] numbers;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = br.readLine();
		Nnum = Integer.parseInt(N);
		M = Integer.parseInt(br.readLine());

		buttons = new boolean[10]; // 버튼 고장 여부, true : 고장
		min = Math.abs(100 - Nnum);

		numbers = new int[N.length() + 1];

		// 고장난 버튼이 없다면 N 채널 길이만큼만 누르면 된다.
		if (((Nnum >= 0 && Nnum < 98) || Nnum > 103) && M == 0) {
			min = N.length();
		} else if (M != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			// 고장난 버튼 표시
			for (int i = 0; i < M; i++) {
				int idx = Integer.parseInt(st.nextToken());
				buttons[idx] = true;
			} // end input
		}

		// 현재 채널이 아니거나 +, -로 이동하는게 최소가 아닌 경우
		if (Nnum != 100 && ((Nnum >= 0 && Nnum < 98) || Nnum > 103)) {

			boolean check = true;

			for (int i = 0; i < N.length(); i++) {

				int now = N.charAt(i) - '0';

				// 멀쩡한 번호인 경우
				if (!buttons[now]) {
					sb.append(now);
				}
				// 고장난 번호인 경우
				else {
					check = false;
					String temp = sb.toString();
					for (int j = 0; j < temp.length() - 1; j++) {
						numbers[j] = temp.charAt(j) - '0';
					}
					int cnt = i - 1;
					if (cnt < 0) {
						cnt = 0;
					}
					perm(cnt, N.length());

					if (N.length() - 1 >= 1) {
						perm(cnt, N.length() - 1);
					}

					perm(cnt, N.length() + 1);
					break;
				}
			} // end for

			if (check) {
				min = Math.min(min, Math.abs(Integer.parseInt(sb.toString()) - Nnum) + N.length());
			}

		} // end if
		System.out.println(min);
	} // end main

	static public void perm(int cnt, int goal) {

		if (cnt == goal) {

			int sum = 0;
			boolean check = true;

			for (int i = 0; i < cnt; i++) {
				if (buttons[numbers[i]]) {
					check = false;
					break;
				}
				sum += numbers[i] * Math.pow(10, cnt - i - 1);
			} // end for

			if (check) {
				min = Math.min(min, Math.abs(sum - Nnum) + goal);
			}

			return;
		}

		for (int i = 0; i < 10; i++) {
			if (buttons[i])
				continue;

			numbers[cnt] = i;
			perm(cnt + 1, goal);
		}
	}

}