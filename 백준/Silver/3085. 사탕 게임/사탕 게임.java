import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, max;
	static char[][] arr;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		max = -1;
		arr = new char[N][N];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			arr[i] = input.toCharArray();
		} // end input

		// row 탐색
		for (int i = 0; i < N; i++) {
			checkRow(i);
		}

		// col 탐색하며 최댓값 찾기
		for (int j = 0; j < N; j++) {
			checkCol(j);
		}

		// row swap
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {

				// 교환
				changeChar(i, j, i, j + 1);

				checkRow(i);
				checkCol(j);
				checkCol(j + 1);

				changeChar(i, j, i, j + 1);
			}
		}

		// col swap
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N - 1; i++) {

				// 교환
				changeChar(i, j, i + 1, j);

				checkRow(i);
				checkRow(i + 1);
				checkCol(j);

				changeChar(i, j, i + 1, j);
			}
		}

		System.out.println(max);

	}

	public static void changeChar(int i, int j, int ni, int nj) {

		char temp = arr[i][j];
		arr[i][j] = arr[ni][nj];
		arr[ni][nj] = temp;
	}

	// 행 체크
	public static void checkRow(int row) {

		int cnt = 1;
		for (int j = 0; j < N - 1; j++) {

			char now = arr[row][j];
			char next = arr[row][j + 1];

			if (now == next)
				cnt++;
			else {
				max = Math.max(max, cnt);
				cnt = 1;
			}
		}

		max = Math.max(max, cnt);
	}

	// 열 체크
	public static void checkCol(int col) {

		int cnt = 1;
		for (int i = 0; i < N - 1; i++) {

			char now = arr[i][col];
			char next = arr[i + 1][col];

			if (now == next)
				cnt++;
			else {
				max = Math.max(max, cnt);
				cnt = 1;
			}
		}

		max = Math.max(max, cnt);
	}

}