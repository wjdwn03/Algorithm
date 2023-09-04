import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, L, R, ans;
	static int[][] arr;
	static boolean[][] visit;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		arr = new int[N][N];
		visit = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end input

		ans = 0;

		while (true) {
			visit = new boolean[N][N];

			boolean check = true;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					// 방문 하지 않은 경우
					if (!visit[i][j]) {
						if (!bfs(i, j)) {
							check = false;
						}
					}
				}
			} // end for i

			if (check)
				break;
			else {
				ans++;
			}
		} // end while

		System.out.println(ans);
	}

	private static boolean bfs(int starti, int startj) {

		Queue<Point> queue = new ArrayDeque<>();

		queue.offer(new Point(starti, startj));
		visit[starti][startj] = true;

		List<Point> list = new ArrayList<>(); // 연합 국가의 위치를 담을 리스트

		list.add(new Point(starti, startj));

		int cnt = 1; // 연합 국가의 개수
		int sum = arr[starti][startj]; // 연합의 인구수

		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nexti = cur.i + di[d];
				int nextj = cur.j + dj[d];

				if (nexti < 0 || nexti >= N || nextj < 0 || nextj >= N || visit[nexti][nextj])
					continue;

				int gab = Math.abs(arr[cur.i][cur.j] - arr[nexti][nextj]);

				if (gab >= L && gab <= R) {
					list.add(new Point(nexti, nextj));
					sum += arr[nexti][nextj];
					cnt++;
					visit[nexti][nextj] = true;
					queue.offer(new Point(nexti, nextj));
				} // end if
			} // end for d
		} // end while

		if (cnt > 1) {
			sum /= cnt;
			for (int i = 0; i < list.size(); i++) {
				arr[list.get(i).i][list.get(i).j] = sum;
			}
			return false;
		}

		return true;
	}

	static class Point {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

}