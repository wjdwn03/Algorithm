import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int i, j, fee;

	public Point(int i, int j, int fee) {
		this.i = i;
		this.j = j;
		this.fee = fee;
	}
}

public class Main {

	static int N;
	static int[][] arr;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		int cnt = 1;

		while (N != 0) {

			arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int ans = bfs();

			sb.append("Problem ").append(cnt++).append(": ").append(ans).append("\n");

			N = Integer.parseInt(br.readLine());
		}

		System.out.println(sb.toString());
	}

	private static int bfs() {

		Queue<Point> queue = new PriorityQueue<>((o1, o2) -> (o1.fee - o2.fee));
		int[][] price = new int[N][N];

		for (int i = 0; i < N; i++) {
			Arrays.fill(price[i], N * N * 9);
		}

		price[0][0] = arr[0][0];
		queue.offer(new Point(0, 0, arr[0][0]));

		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nexti = cur.i + di[d];
				int nextj = cur.j + dj[d];

				if (nexti < 0 || nexti >= N || nextj < 0 || nextj >= N
						|| price[nexti][nextj] <= cur.fee + arr[nexti][nextj])
					continue;

				price[nexti][nextj] = cur.fee + arr[nexti][nextj];
				queue.offer(new Point(nexti, nextj, cur.fee + arr[nexti][nextj]));

			}
		}
		return price[N - 1][N - 1];
	}

}