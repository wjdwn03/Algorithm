import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K;
	static int[][] arr;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[M][N];

		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());

			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int i = y1; i < y2; i++) {
				for (int j = x1; j < x2; j++) {
					arr[i][j] = 1;
				}
			}
		} // end input

		List<Integer> list = new ArrayList<>(); // 각 영역의 넓이를 저장할 리스트

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 0) {
					list.add(bfs(i, j));
				}
			}
		}

		sb.append(list.size()).append("\n");

		Collections.sort(list);

		for (int num : list) {
			sb.append(num).append(" ");
		}

		System.out.println(sb.toString());

	}

	private static int bfs(int nowi, int nowj) {
		Queue<Point> queue = new ArrayDeque<>();

		queue.offer(new Point(nowi, nowj));

		arr[nowi][nowj] = 2;
		int area = 1;

		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nexti = cur.i + di[d];
				int nextj = cur.j + dj[d];

				if (nexti < 0 || nexti >= M || nextj < 0 || nextj >= N || arr[nexti][nextj] != 0)
					continue;

				arr[nexti][nextj] = 2; // 방문 표시
				area++;
				queue.offer(new Point(nexti, nextj));
			}
		}

		return area;
	}

	static class Point {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

}