import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M, R;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열
		R = Integer.parseInt(st.nextToken()); // 연산의 수

		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] ans = deepcopy(arr);

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			int option = Integer.parseInt(st.nextToken());
			int[][] tmp;
			switch (option) {
			case 1:
				tmp = one(ans, ans.length, ans[0].length); // 상하 반전
				break;
			case 2:
				tmp = two(ans, ans.length, ans[0].length); // 좌우 반전
				break;
			case 3:
				tmp = three(ans, ans.length, ans[0].length); // 오른쪽으로 90도 회전
				break;
			case 4:
				tmp = four(ans, ans.length, ans[0].length); // 왼쪽으로 90도 회전
				break;
			case 5:
				tmp = five(ans, ans.length, ans[0].length); // 4개의 부분 배열 오른쪽으로 회전
				break;
			default:
				tmp = six(ans, ans.length, ans[0].length); // 4개의 부분 배열 왼쪽으로 회전
				break;
			}
			ans = deepcopy(tmp);
		}

		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[0].length; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static int[][] six(int[][] ans, int N, int M) {
		int[][] val = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 2->1
				if (i < N / 2 && j < M / 2) {
					val[i][j] = ans[i][j + M / 2];
				}
				// 3->2
				else if (i < N / 2 && j >= M / 2) {
					val[i][j] = ans[i + N / 2][j];
				}
				// 4->3
				else if (i >= N / 2 && j >= M / 2) {
					val[i][j] = ans[i][j - M / 2];
				}
				// 1->4
				else {
					val[i][j] = ans[i - N / 2][j];
				}
			}
		}
		return val;
	}

	private static int[][] five(int[][] ans, int N, int M) {
		int[][] val = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 4->1
				if (i < N / 2 && j < M / 2) {
					val[i][j] = ans[i + N / 2][j];
				}
				// 1->2
				else if (i < N / 2 && j >= M / 2) {
					val[i][j] = ans[i][j - M / 2];
				}
				// 2->3
				else if (i >= N / 2 && j >= M / 2) {
					val[i][j] = ans[i - N / 2][j];
				}
				// 3->4
				else {
					val[i][j] = ans[i][j + M / 2];
				}
			}
		}
		return val;
	}

	private static int[][] four(int[][] ans, int N, int M) {
		int[][] val = new int[M][N];
		for (int j = M - 1; j >= 0; j--) {
			for (int i = 0; i < N; i++) {
				val[M - 1 - j][i] = ans[i][j];
			}
		}
		return val;
	}

	private static int[][] three(int[][] ans, int N, int M) {
		int[][] val = new int[M][N];
		for (int j = 0; j < M; j++) {
			for (int i = N - 1; i >= 0; i--) {
				val[j][N - 1 - i] = ans[i][j];
			}
		}
		return val;
	}

	private static int[][] two(int[][] ans, int N, int M) {
		int[][] val = new int[N][M];
		for (int j = 0; j < M; j++) {
			int idx = M - 1 - j;
			for (int i = 0; i < N; i++) {
				val[i][j] = ans[i][idx];
			}
		}
		return val;
	}

	private static int[][] one(int[][] ans, int N, int M) {
		int[][] val = new int[N][M];
		for (int i = 0; i < N; i++) {
			int idx = N - 1 - i;
			for (int j = 0; j < M; j++) {
				val[i][j] = ans[idx][j];
			}
		}
		return val;
	}

	private static int[][] deepcopy(int[][] arr) {
		int[][] val = new int[arr.length][arr[0].length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				val[i][j] = arr[i][j];
			}
		}
		return val;
	}

}
