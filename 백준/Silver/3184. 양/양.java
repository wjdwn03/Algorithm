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

	static int R, C, wolf, sheep;
	static char[][] arr;
	static boolean[][] visit;
	static int[] di = { 1, -1, 0, 0 };
	static int[] dj = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new char[R][C];
		visit = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = input.charAt(j);
			}
		} // end input

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] != '#' && !visit[i][j]) {
					bfs(i, j);
				}
			}
		}

		sb.append(sheep).append(" ").append(wolf);
		System.out.println(sb.toString());
	}

	private static void bfs(int starti, int startj) {
		Queue<Point> queue = new ArrayDeque<>();

		visit[starti][startj] = true;
		queue.offer(new Point(starti, startj));

		int sCnt = 0, wCnt = 0;

		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			if (arr[cur.i][cur.j] == 'v')
				wCnt++;
			else if (arr[cur.i][cur.j] == 'o')
				sCnt++;

			for (int d = 0; d < 4; d++) {
				int nexti = cur.i + di[d];
				int nextj = cur.j + dj[d];

				if (nexti < 0 || nexti >= R || nextj < 0 || nextj >= C || visit[nexti][nextj]
						|| arr[nexti][nextj] == '#')
					continue;

				visit[nexti][nextj] = true;
				queue.offer(new Point(nexti, nextj));
			}
		} // end while

		if (sCnt > wCnt)
			sheep += sCnt;
		else
			wolf += wCnt;

	} // end bfs

}