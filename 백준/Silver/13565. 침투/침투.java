import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int i, j;

	public Point(int i, int j) {
		this.i = i;
		this.j = j;
	}
}

public class Main {

	static int N, M;
	static String ans;
	static int[][] arr;
	static boolean[][] visit;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = input.charAt(j) - '0';
			}
		} // end input

		ans = "NO";

		for (int j = 0; j < M; j++) {
			if (arr[0][j] == 0 && !visit[0][j]) {
				bfs(0, j);
			}
			if (ans.equals("YES"))
				break;
		}

		System.out.println(ans);
	}

	private static void bfs(int starti, int startj) {

		Queue<Point> queue = new ArrayDeque<>();

		queue.offer(new Point(starti, startj));
		visit[starti][startj] = true;

		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nexti = cur.i + di[d];
				int nextj = cur.j + dj[d];

				if (arr[cur.i][cur.j] == 0 && nexti >= N) {
					ans = "YES";
					return;
				}

				if (nexti < 0 || nexti >= N || nextj < 0 || nextj >= M || visit[nexti][nextj] || arr[nexti][nextj] == 1)
					continue;

				queue.offer(new Point(nexti, nextj));
				visit[nexti][nextj] = true;

			}
		}

	}

}