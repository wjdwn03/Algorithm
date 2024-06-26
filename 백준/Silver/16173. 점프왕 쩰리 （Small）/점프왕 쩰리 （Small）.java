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

	static int N;
	static int[][] map;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end input

		boolean check = bfs();

		if (check) {
			System.out.println("HaruHaru");
		} else {
			System.out.println("Hing");
		}
	}

	private static boolean bfs() {

		boolean[][] visit = new boolean[N][N];
		Queue<Point> queue = new ArrayDeque<>();

		visit[0][0] = true;
		queue.offer(new Point(0, 0));

		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			if (cur.i == N - 1 && cur.j == N - 1)
				break;

			for (int d = 0; d < 4; d++) {
				int nexti = cur.i + di[d] * map[cur.i][cur.j];
				int nextj = cur.j + dj[d] * map[cur.i][cur.j];

				if (nexti < 0 || nexti >= N || nextj < 0 || nextj >= N || visit[nexti][nextj])
					continue;

				visit[nexti][nextj] = true;
				queue.offer(new Point(nexti, nextj));
			}
		}

		return visit[N - 1][N - 1];
	}

}