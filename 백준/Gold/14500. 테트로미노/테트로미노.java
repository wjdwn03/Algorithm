import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M, max;
	static int[][] arr;
	static int[] di = { 1, 1, -1, -1 };
	static int[] dj = { 1, -1, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		max = -1;

		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end input

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				// 직선 - 가로
				if (j + 3 < M) {
					line(false, true, i, j);
				}
				// 직선 - 세로
				if (i + 3 < N) {
					line(true, false, i, j);
				}

				// 사각형
				if ((i + 1 < N) && (j + 1 < M)) {
					square(i, j);
				}

				// ㄴ자
				for (int d = 0; d < 4; d++) {
					tetrominoL(true, false, i, di[d], j, dj[d]);
					tetrominoL(false, true, i, di[d], j, dj[d]);
				}

				// s자
				for (int d = 0; d < 2; d++) {

					tetrominoS(true, i, di[d], j, dj[d]);
					tetrominoS(false, i, di[d], j, dj[d]);
				}

				// ㅏ자
				tetrominoA(true, false, i, di[0], j, dj[0]); // ㅏ
				tetrominoA(true, false, i, di[0], j, dj[1]); // ㅓ
				tetrominoA(false, true, i, di[2], j, dj[0]); // ㅗ
				tetrominoA(false, true, i, di[0], j, dj[0]); // ㅜ

			} // end for j
		} // end for i

		System.out.println(max);

	}

	// 직선
	public static void line(boolean len, boolean width, int nowi, int nowj) {

		int sum = 0;

		if (len) {
			for (int i = nowi; i < nowi + 4; i++) {
				sum += arr[i][nowj];
			}

		}

		if (width) {
			for (int j = nowj; j < nowj + 4; j++) {
				sum += arr[nowi][j];
			}
		}

		max = Math.max(max, sum);

	}

	// 사각형
	public static void square(int nowi, int nowj) {

		int sum = 0;

		for (int i = nowi; i < nowi + 2; i++) {
			for (int j = nowj; j < nowj + 2; j++) {
				sum += arr[i][j];
			}
		}

		max = Math.max(max, sum);

	}

	// ㄴ자
	public static void tetrominoL(boolean len, boolean width, int nowi, int iOperator, int nowj, int jOperator) {

		int sum = 0;

		if (len) {

			if (nowj + jOperator < 0 || nowj + jOperator >= M)
				return;

			int i = 0;

			for (int idx = 0; idx < 3; idx++) {
				i = nowi + (idx * iOperator);

				if (i < 0 || i >= N)
					return;

				sum += arr[i][nowj];
			}

			sum += arr[i][nowj + jOperator];
		}

		if (width) {

			if (nowi + iOperator < 0 || nowi + iOperator >= N)
				return;

			int j = 0;

			for (int idx = 0; idx < 3; idx++) {
				j = nowj + (idx * jOperator);

				if (j < 0 || j >= M)
					return;

				sum += arr[nowi][j];
			}

			sum += arr[nowi + iOperator][j];
		}

		max = Math.max(max, sum);

	}

	// s자
	public static void tetrominoS(boolean startI, int nowi, int iOperator, int nowj, int jOperator) {

		int sum = 0;

		if (startI) {

			if (nowi + 2 >= N || nowj + jOperator < 0 || nowj + jOperator >= M)
				return;

			int i = 0;

			for (int idx = 0; idx < 2; idx++) {

				i = nowi + (idx * iOperator);
				sum += arr[i][nowj];
			}

			sum += arr[i][nowj + jOperator];

			sum += arr[i + 1][nowj + jOperator];

		} else {

			if ((nowj + 2 * jOperator) < 0 || nowj + 2 * jOperator >= M || nowi + iOperator < 0
					|| nowi + iOperator >= N)
				return;

			int j = 0;

			for (int idx = 0; idx < 2; idx++) {
				j = nowj + idx * jOperator;

				sum += arr[nowi][j];
			}

			sum += arr[nowi + iOperator][j];

			sum += arr[nowi + iOperator][j + jOperator];

		}

		max = Math.max(max, sum);

	}

	// ㅏ자
	public static void tetrominoA(boolean len, boolean width, int nowi, int iOperator, int nowj, int jOperator) {

		int sum = 0;

		if (len) {

			if (nowi + 2 * iOperator < 0 || nowi + 2 * iOperator >= N || nowj + jOperator < 0 || nowj + jOperator >= M)
				return;

			int i = 0;

			for (int idx = 0; idx < 3; idx++) {

				i = nowi + idx * iOperator;
				sum += arr[i][nowj];
			}

			i = nowi + iOperator;
			sum += arr[i][nowj + jOperator];

		}

		if (width) {

			if (nowj + 2 * jOperator < 0 || nowj + 2 * jOperator >= M || nowi + iOperator < 0 || nowi + iOperator >= N)
				return;

			int j = 0;

			for (int idx = 0; idx < 3; idx++) {

				j = nowj + idx * jOperator;
				sum += arr[nowi][j];
			}

			j = nowj + jOperator;
			sum += arr[nowi + iOperator][j];

		}

		max = Math.max(max, sum);

	}

}