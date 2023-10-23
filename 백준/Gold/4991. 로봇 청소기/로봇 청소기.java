import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int W, H, starti, startj, min, dustSize;
	static char[][] room;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	static boolean[] visit;
	static int[][] distance;
	static List<Point> dust;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		while (W != 0 && H != 0) {

			min = Integer.MAX_VALUE;

			room = new char[H][W];
			dust = new ArrayList<>();

			for (int i = 0; i < H; i++) {
				String input = br.readLine();
				for (int j = 0; j < W; j++) {
					room[i][j] = input.charAt(j);
					if (room[i][j] == 'o') {
						dust.add(0, new Point(i, j));
					} else if (room[i][j] == '*') {
						dust.add(new Point(i, j));
					}
				}
			}

			dustSize = dust.size();

			distance = new int[dustSize][dustSize];
			visit = new boolean[dustSize];

			countDist();
			sb.append(min).append("\n");

			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

		}

		System.out.println(sb.toString());
	}

	private static void countDist() {

		for (int i = 0; i < dustSize; i++) {
			for (int j = i + 1; j < dustSize; j++) {
                
                // 청소기, 먼지 사이의 모든 거리 먼저 계산
				int result = bfs(dust.get(i), dust.get(j));

				if (result == -1) {
					min = -1;
					return;
				}

				distance[i][j] = distance[j][i] = result;
			}
		}

        // 모든 먼지에 방문할 때 최소 거리 계산
		perm(0, 0, 0);

	}

	private static void perm(int now, int cnt, int sum) {

        // dustSize에는 로봇청소기까지 포함되어 있음.
        // 먼지 개수만 확인해야 하므로 -1을 해준다.
		if (cnt == dustSize - 1) {
			min = Math.min(min, sum);
			return;
		}

		for (int i = 1; i < dustSize; i++) {
			if (visit[i])
				continue;

			visit[i] = true;
			perm(i, cnt + 1, sum + distance[now][i]);
			visit[i] = false;
		}

	}

	private static int bfs(Point start, Point goal) {
		Queue<Point> queue = new ArrayDeque<>();
		boolean[][] visit = new boolean[H][W];

		queue.offer(start);
		visit[start.i][start.j] = true;

		int move = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				Point cur = queue.poll();

				if (cur.i == goal.i && cur.j == goal.j)
					return move;

				for (int d = 0; d < 4; d++) {
					int nexti = cur.i + di[d];
					int nextj = cur.j + dj[d];

					if (nexti < 0 || nexti >= H || nextj < 0 || nextj >= W || visit[nexti][nextj]
							|| room[nexti][nextj] == 'x')
						continue;

					queue.offer(new Point(nexti, nextj));
					visit[nexti][nextj] = true;
				}
			}

			move++;
		}

		return -1;
	}

	static class Point {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

}