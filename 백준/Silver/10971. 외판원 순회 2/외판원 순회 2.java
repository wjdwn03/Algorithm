import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, min;
	static int[][] arr;
	static int[] numbers;
	static boolean[] isSelected;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];
		numbers = new int[N];
		isSelected = new boolean[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end input

		min = Integer.MAX_VALUE;

		perm(0);

		System.out.println(min);
	}

	private static void perm(int cnt) {

		if (cnt == N) {

			int sum = 0;

			for (int i = 0; i < N - 1; i++) {

				if (arr[numbers[i]][numbers[i + 1]] == 0)
					return;

				sum += arr[numbers[i]][numbers[i + 1]];

				if (sum >= min)
					return;
			}

			if (arr[numbers[N - 1]][numbers[0]] == 0)
				return;

			sum += arr[numbers[N - 1]][numbers[0]];

			min = Math.min(min, sum);

			return;
		}

		for (int i = 0; i < N; i++) {

			if (isSelected[i])
				continue;

			numbers[cnt] = i;
			isSelected[i] = true;
			perm(cnt + 1);
			isSelected[i] = false;

		}

	}

}