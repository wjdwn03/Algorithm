import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Main {

	static int N, ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][N];
		ans = 0;

		for (int i = 0; i < N; i++) {
			arr = new int[N][N];
			arr[0][i] = 2;
			dfs(1, arr);
		}

		System.out.println(ans);
	}

	private static void dfs(int cnt, int[][] arr) {

		if (cnt == N) {
			ans++;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (check(cnt, i, arr)) {
				arr[cnt][i] = 2;
				dfs(cnt + 1, arr);
				arr[cnt][i] = 0;
			}
		}

	}

	private static boolean check(int cnt, int now, int[][] arr) {

		for (int i = 0; i < cnt; i++) {
			if (arr[i][now] == 2)
				return false;
		}

		int ni = cnt - 1;
		int nj = now - 1;
		while (ni >= 0 && nj >= 0) {
			if (arr[ni][nj] == 2)
				return false;
			ni--;
			nj--;
		}

		ni = cnt - 1;
		nj = now + 1;
		while (nj < N && ni >= 0) {
			if (arr[ni][nj] == 2)
				return false;
			ni--;
			nj++;
		}

		return true;
	}

}