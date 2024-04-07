import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, dis;
	static char[][] arr;
	static int[] di = { 1, -1, 0, 0 };
	static int[] dj = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new char[N][M];
		dis = 0; // 도착지까지의 거리

		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		bfs();

		System.out.println(dis);
	}

	private static void bfs() {
		Queue<Point> queue = new ArrayDeque<>();
		boolean[][] visit = new boolean[N][M];

		queue.offer(new Point(0, 0));
		visit[0][0] = true;

		while (!queue.isEmpty()) {
			int size = queue.size();

			dis++;

			for (int s = 0; s < size; s++) {
				Point cur = queue.poll();

				if (cur.i == N - 1 && cur.j == M - 1)
					return;

				for (int d = 0; d < 4; d++) {
					int nexti = cur.i + di[d];
					int nextj = cur.j + dj[d];

					if (nexti < 0 || nexti >= N || nextj < 0 || nextj >= M || visit[nexti][nextj]
							|| arr[nexti][nextj] == '0')
						continue;
					visit[nexti][nextj] = true;
					queue.offer(new Point(nexti, nextj));

				}
			}
		}
	}

}

class Point {
	int i, j;

	public Point(int i, int j) {
		this.i = i;
		this.j = j;
	}
}