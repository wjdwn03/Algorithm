import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		char[][] arr = new char[N][N];

		int rowCnt = 0, colCnt = 0;

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			int cnt = 0;
			boolean check = false;

			for (int j = 0; j < N; j++) {

				arr[i][j] = input.charAt(j);

				if (arr[i][j] == 'X') {
					cnt = 0;
					check = false;
					continue;
				}
				cnt++;

				if (!check && cnt >= 2) {
					check = true;
					rowCnt++;
				}
			}

		}

		for (int j = 0; j < N; j++) {
			int cnt = 0;
			boolean check = false;

			for (int i = 0; i < N; i++) {
				if (arr[i][j] == 'X') {
					cnt = 0;
					check = false;
					continue;
				}

				cnt++;

				if (!check && cnt >= 2) {
					check = true;
					colCnt++;
				}
			}

		}

		System.out.println(rowCnt + " " + colCnt);
	}

}