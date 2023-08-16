import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;
	static HashMap<Integer, Integer> hashmap;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		arr = new int[5][5];
		hashmap = new HashMap<>();

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end input

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				dfs(i, j, arr[i][j], 1);
			}
		}

		System.out.println(hashmap.size());
	}

	private static void dfs(int nowi, int nowj, int num, int cnt) {
		if (cnt == 6) {
			if (!hashmap.containsKey(num)) {
				hashmap.put(num, 1);
			}

			return;
		}

		for (int d = 0; d < 4; d++) {
			int nexti = nowi + di[d];
			int nextj = nowj + dj[d];

			if (nexti < 0 || nexti >= 5 || nextj < 0 || nextj >= 5)
				continue;

			dfs(nexti, nextj, num * 10 + arr[nexti][nextj], cnt + 1);
		}
	}

	static class Point {
		int i, j;
		String num;

		public Point(int i, int j, String num) {
			this.i = i;
			this.j = j;
			this.num = num;
		}
	}

}