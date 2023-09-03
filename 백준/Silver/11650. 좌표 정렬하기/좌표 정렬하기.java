import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		Queue<Point> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			pq.add(new Point(x, y));
		}

		for (int i = 0; i < N; i++) {
			Point cur = pq.poll();
			sb.append(cur.i).append(" ").append(cur.j).append("\n");
		}

		System.out.println(sb.toString());
	}

	static class Point implements Comparable<Point> {

		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}

		@Override
		public int compareTo(Point o) {
			if (this.i == o.i) {
				return this.j - o.j;
			} else {
				return this.i - o.i;
			}
		}
	}
}