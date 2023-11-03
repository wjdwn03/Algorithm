import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int H, W;
	static int[][] arr;
	static char[][] cloud;
	static List<Point> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		arr = new int[H][W];
		cloud = new char[H][W];
		list = new ArrayList<>();

		for (int i = 0; i < H; i++) {

			Arrays.fill(arr[i], -1);

			String input = br.readLine();

			for (int j = 0; j < W; j++) {
				cloud[i][j] = input.charAt(j);
				if (cloud[i][j] == 'c')
					list.add(new Point(i, j, 0));
			}
		}

		bfs();

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	private static void bfs() {
		Queue<Point> queue = new ArrayDeque<>();
		boolean[][] visit = new boolean[H][W];

		for (int i = 0; i < list.size(); i++) {
			int h = list.get(i).i;
			int w = list.get(i).j;
			queue.offer(new Point(h, w, 0));
			arr[h][w] = 0;
			visit[h][w] = true;
		}

		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			int nextj = cur.j + 1;

			if (nextj >= W || visit[cur.i][nextj] || arr[cur.i][nextj] == 'c')
				continue;

			visit[cur.i][nextj] = true;
			arr[cur.i][nextj] = cur.cnt + 1;

			queue.offer(new Point(cur.i, nextj, cur.cnt + 1));

		}
	}

	static class Point {
		int i, j, cnt;

		public Point(int i, int j, int cnt) {
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}
	}

}