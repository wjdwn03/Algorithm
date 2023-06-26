import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, H, zero;
	static int[][][] arr;
	static List<Point> list;
	static int[] di = { -1, 1, 0, 0, 0, 0 };
	static int[] dj = { 0, 0, -1, 1, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		arr = new int[N][M][H];
		list = new ArrayList<>();
		zero = 0;

		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < M; j++) {

					int num = Integer.parseInt(st.nextToken());
					arr[i][j][h] = num;

					if (num == 1) {
						list.add(new Point(i, j, h, 0));
					}
					if (num == 0)
						zero++;
				}
			}
		} // end input

		int ans = 0;

		if (zero != 0) {
			ans = bfs();
		}

		System.out.println(ans);

	}

	private static int bfs() {

		Queue<Point> queue = new ArrayDeque<>();

		for (int idx = 0; idx < list.size(); idx++) {
			queue.offer(new Point(list.get(idx).i, list.get(idx).j, list.get(idx).h, 0));
		}

		int day = 0;

		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			for (int d = 0; d < 6; d++) {
				int nexti = cur.i + di[d];
				int nextj = cur.j + dj[d];
				int nexth = cur.h + dh[d];

				if (nexti < 0 || nexti >= N || nextj < 0 || nextj >= M || nexth < 0 || nexth >= H)
					continue;

				if (arr[nexti][nextj][nexth] == 0) {
					arr[nexti][nextj][nexth] = 1;
					queue.offer(new Point(nexti, nextj, nexth, cur.day + 1));
					zero--;
				}

			} // end for d

			day = cur.day;
			
		} // end while
		
		
		if (zero == 0) {
			return day;
		} else {
			return -1;
		}

	}

	static class Point {
		int i, j, h, day;

		public Point(int i, int j, int h, int day) {
			this.i = i;
			this.j = j;
			this.h = h;
			this.day = day;
		}
	}

}