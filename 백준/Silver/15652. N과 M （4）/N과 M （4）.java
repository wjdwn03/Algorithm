import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static List<int[]> list;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			int[] arr = new int[M];
			arr[0] = i;
			dfs(1, i, arr);
		}
		System.out.println(sb.toString());

	}

	private static void dfs(int cnt, int start, int[] arr) {

		if (cnt >= M) {
			boolean check = true;
			for (int i = 1; i < M; i++) {
				if (arr[i - 1] > arr[i]) {
					check = false;
					break;
				}
			}
			if (check) {

				for (int i = 0; i < M; i++) {
					sb.append(arr[i]).append(" ");
				}
				sb.append("\n");
			}
			return;
		}

		for (int i = start; i <= N; i++) {
			arr[cnt] = i;
			dfs(cnt + 1, start, arr);
		}

	}

	static class Point {
		int n, m;

		public Point(int n, int m) {
			this.n = n;
			this.m = m;
		}
	}

}
