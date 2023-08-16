import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;
	static HashMap<String, Integer> hashmap;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;

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
				sb = new StringBuilder();
				bfs(i, j, String.valueOf(arr[i][j]));
			}
		}

		System.out.println(hashmap.size());
	}

	private static void bfs(int nowi, int nowj, String num) {

		Queue<Point> queue = new ArrayDeque<>();

		queue.offer(new Point(nowi, nowj, num));

		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			if (cur.num.length() > 6)
				continue;

			if (cur.num.length() == 6) {
				if (!hashmap.containsKey(cur.num)) {
					hashmap.put(cur.num, 1);
				}
				continue;
			}

			for (int d = 0; d < 4; d++) {
				int nexti = cur.i + di[d];
				int nextj = cur.j + dj[d];

				if (nexti < 0 || nexti >= 5 || nextj < 0 || nextj >= 5)
					continue;

				String nextNum = cur.num + arr[nexti][nextj];

				queue.offer(new Point(nexti, nextj, nextNum));
			}
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