import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, blackCnt, whiteCnt;
	static int[][] chess;
	static boolean[][] bishop; // 비숍이 놓여 있거나 비숍의 영향권에 있는 위치는 true
	static int[] di = { 1, 1, -1, -1 };
	static int[] dj = { 1, -1, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		blackCnt = 0;
		whiteCnt = 0;

		chess = new int[N][N];
		bishop = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				chess[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end input

		blackSearch(0, 0, 0);

		bishop = new boolean[N][N];

		whiteSearch(0, 1, 0);

		System.out.println(blackCnt + whiteCnt);
	}

	private static void whiteSearch(int i, int j, int cnt) {

		if (whiteCnt < cnt) {
			whiteCnt = cnt;
		}

		if (j >= N) {
			i++;
			j = i % 2 == 0 ? 1 : 0;
		}

		if (i >= N)
			return;

		if (check(i, j)) {
			bishop[i][j] = true;
			whiteSearch(i, j + 2, cnt + 1);
			bishop[i][j] = false;
		}

		whiteSearch(i, j + 2, cnt);

	}

	private static void blackSearch(int i, int j, int cnt) {

		if (blackCnt < cnt) {
			blackCnt = cnt;
		}

		if (j >= N) {
			i++;
			j = i % 2 == 0 ? 0 : 1;
		}

		if (i >= N)
			return;

		if (check(i, j)) {
			bishop[i][j] = true;
			blackSearch(i, j + 2, cnt + 1);
			bishop[i][j] = false;
		}

		blackSearch(i, j + 2, cnt);

	}

	// 비숍을 놓을 수 있는지
	private static boolean check(int starti, int startj) {

		if (chess[starti][startj] == 0)
			return false;

		for (int d = 0; d < 4; d++) {
			int nexti = starti + di[d];
			int nextj = startj + dj[d];

			while (nexti >= 0 && nexti < N && nextj >= 0 && nextj < N) {

				if (bishop[nexti][nextj])
					return false;

				nexti += di[d];
				nextj += dj[d];

			}
		}

		return true;

	}

}