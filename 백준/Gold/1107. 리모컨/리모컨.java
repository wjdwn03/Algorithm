import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.xml.transform.Templates;

public class Main {

	static int N, M, min;
	static boolean[] buttons;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		buttons = new boolean[10]; // 버튼 고장 여부, true : 고장
		min = Math.abs(100 - N);

		// 고장난 버튼이 없다면 N 채널 길이만큼만 누르면 된다.
		if (((N >= 0 && N < 98) || N > 103) && M == 0) {
			min = String.valueOf(N).length();
		} else if (M != 0) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			// 고장난 버튼 표시
			for (int i = 0; i < M; i++) {
				int idx = Integer.parseInt(st.nextToken());
				buttons[idx] = true;
			} // end input
		}

		// 현재 채널이 아니거나 +, -로 이동하는게 최소가 아닌 경우
		if (N != 100 && ((N >= 0 && N < 98) || N > 103)) {

			dfs(0, 0);

		} // end if

		System.out.println(min);

	} // end main

	static public void dfs(int idx, int num) {

		if (idx != 0) {
			min = Math.min(min, Math.abs(num - N) + idx);
		}

		if (idx == 6)
			return;

		for (int i = 0; i < 10; i++) {
			if (!buttons[i]) {
				dfs(idx + 1, num * 10 + i);
			}
		}

	}

}