import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, baby, cnt, time, fishCnt, sharkI, sharkJ;
	static int[][] arr;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		baby = 2; // 아기 상어 크기
		cnt = 0; // 아기 상어가 먹은 물고기 수
		time = 0; // 이동 시간
		fishCnt = 0; // 물고기 수

		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

				if (arr[i][j] == 9) {
					sharkI = i;
					sharkJ = j;
					arr[i][j] = 0;
				}

				else if (arr[i][j] > 0 && arr[i][j] < 7) {
					fishCnt++;
				}
			}
		} // end input

		bfs();

		System.out.println(time);
	}

	private static void bfs() {

		PriorityQueue<Point> pq = new PriorityQueue<>();

		boolean[][] visit = new boolean[N][N];

		visit[sharkI][sharkJ] = true;
		pq.offer(new Point(sharkI, sharkJ, 0));

		while (!pq.isEmpty()) {
			Point cur = pq.poll();

			if (arr[cur.i][cur.j] > 0 && arr[cur.i][cur.j] < baby) {

				time = cur.dis;
				arr[cur.i][cur.j] = 0;

				if (baby == ++cnt) {
					baby++;
					cnt = 0;
					if (--fishCnt == 0)
						return;
				}

				visit = new boolean[N][N];
				visit[cur.i][cur.j] = true;
				pq.clear();
			}

			for (int d = 0; d < 4; d++) {
				int nexti = cur.i + di[d];
				int nextj = cur.j + dj[d];

				if (nexti < 0 || nexti >= N || nextj < 0 || nextj >= N || arr[nexti][nextj] > baby
						|| visit[nexti][nextj])
					continue;

				visit[nexti][nextj] = true;
				pq.offer(new Point(nexti, nextj, cur.dis + 1));
			}

		} // end while

	}

	static class Point implements Comparable<Point> {
		int i, j, dis;

		public Point(int i, int j, int dis) {
			this.i = i;
			this.j = j;
			this.dis = dis;
		}

		@Override
		public int compareTo(Point o) {
			if (this.dis == o.dis) {
				if (this.i == o.i)
					return this.j - o.j;
				return this.i - o.i;
			}
			return this.dis - o.dis;
		}
	}

}