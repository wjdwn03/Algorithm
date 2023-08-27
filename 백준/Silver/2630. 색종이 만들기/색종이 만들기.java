import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, white, blue;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		arr = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end input

		white = 0;
		blue = 0;

		dfs(1, 1, N);

		sb.append(white).append("\n").append(blue);
		System.out.println(sb.toString());
	}

	private static void dfs(int row, int col, int size) {

		if (size == 1) {
			if (arr[row][col] == 1) {
				blue++;
			} else
				white++;
			return;
		}

		if (check(row, col, size)) {
			return;
		}

		int nextSize = size / 2;

		dfs(row, col + nextSize, nextSize); // 1사분면
		dfs(row, col, nextSize); // 2사분면
		dfs(row + nextSize, col, nextSize); // 3사분면
		dfs(row + nextSize, col + nextSize, nextSize); // 4사분면

	}

	private static boolean check(int row, int col, int size) {

		int color = arr[row][col];

		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (color != arr[i][j])
					return false;
			}
		}

		if (color == 0) {
			white++;
			return true;
		} else {
			blue++;
			return true;
		}

	}

}