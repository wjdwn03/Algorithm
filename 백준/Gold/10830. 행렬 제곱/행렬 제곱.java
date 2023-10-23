import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static long B;
	static int[][] origin;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());

		origin = new int[N][N]; // 제곱할 때 곱할 원본 배열
		int[][] arr = new int[N][N]; // 제곱한 결과를 저장할 배열

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				// 몇 번을 제곱하든 1000으로 나눌 것이기 때문에 처음부터 1000으로 나눈 나머지를 저장
				origin[i][j] = Integer.parseInt(st.nextToken()) % 1000;
			}
		} // end input

		arr = calculate(origin, B);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());

	}

	private static int[][] calculate(int[][] arr, long b) {

		if (b == 1L)
			return arr;

		int[][] result = calculate(arr, b / 2);

		// 분할 정복으로 풀기 때문에 자기 자신을 먼저 제곱한다.
		result = multiply(result, result);

		// 홀수일 경우, origin을 한 번 더 곱해준다.
		if (b % 2 == 1L) {
			result = multiply(result, origin);
		}

		return result;
	}

	private static int[][] multiply(int[][] arr1, int[][] arr2) {

		int[][] result = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int idx = 0; idx < N; idx++) {
				for (int j = 0; j < N; j++) {
					result[i][idx] += arr1[i][j] * arr2[j][idx];
					result[i][idx] %= 1000;
				}

			}

		}

		return result;

	}

}