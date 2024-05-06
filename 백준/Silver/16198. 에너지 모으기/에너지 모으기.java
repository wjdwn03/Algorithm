import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, max;
	static int[] origin;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		max = -1;
		origin = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			origin[i] = Integer.parseInt(st.nextToken());
		} // end input

		for (int i = 1; i < N - 1; i++) {
			int[] arr = new int[N - 1];
			int idx = 0;

			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;
				arr[idx++] = origin[j];
			}

			dfs(arr, N - 1, origin[i - 1] * origin[i + 1]);
		}

		System.out.println(max);
	}

	private static void dfs(int[] arr, int size, int energy) {

		if (size == 2) {
			max = Math.max(max, energy);
			return;
		}

		for (int i = 1; i < size - 1; i++) {
			int[] newArr = new int[size - 1];
			int idx = 0;

			for (int j = 0; j < size; j++) {
				if (i == j)
					continue;
				newArr[idx++] = arr[j];
			}

			dfs(newArr, size - 1, energy + arr[i - 1] * arr[i + 1]);
		}
	}

}