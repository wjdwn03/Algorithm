import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K, ans;
	static int[][] arr;
	static List<int[][]> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		list = new ArrayList<>();
		ans = 0; // 스티커가 붙은 칸의 수

		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			int[][] sticker = new int[r][c];
			int oneCnt = 0;

			for (int i = 0; i < r; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < c; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
					if (sticker[i][j] == 1) {
						oneCnt++;
					}
				}
			}

			for (int i = 0; i < 4; i++) {

				// 스티커 붙이기
				if (putSticker(sticker, oneCnt))
					break;

				// 스티커 회전
				sticker = rotate(sticker);

			}

		} // end for k

		System.out.println(ans);

	}

	private static boolean putSticker(int[][] sticker, int oneCnt) {

		boolean check = true;

		int r = sticker.length;
		int c = sticker[0].length;
		int[][] copy = deepCopy();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				// 스티커가 배열의 범위를 넘지 않는 경우 스티커를 붙일 수 있는지 확인함.
				if (i + r - 1 < N && j + c - 1 < M) {

					check = true;
					copy = deepCopy();

					for (int ii = 0; ii < r; ii++) {
						for (int jj = 0; jj < c; jj++) {

							// 스티커를 붙일 수 있는 경우
							if (sticker[ii][jj] == 0 || (copy[i + ii][j + jj] == 0 && sticker[ii][jj] == 1)) {

								if (sticker[ii][jj] == 1)
									copy[i + ii][j + jj] = sticker[ii][jj];

								continue;
							}

							check = false;
							break;
						} // end for jj

						if (!check)
							break;
					} // end for ii

				} // end if

				// 배열 범위를 벗어나는 경우
				else {
					check = false;
				}

				if (check) {
					arr = copy;
					ans += oneCnt;
					break;
				}
			} // end for j

			if (check)
				break;
		}

		return check;

	}

	private static int[][] deepCopy() {

		int[][] result = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				result[i][j] = arr[i][j];
			}
		}
		return result;
	}

	private static int[][] rotate(int[][] arr) {

		int r = arr[0].length;
		int c = arr.length;

		int[][] result = new int[r][c];

		for (int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++) {
				result[j][c - 1 - i] = arr[i][j];
			}
		}

		return result;
	}

}