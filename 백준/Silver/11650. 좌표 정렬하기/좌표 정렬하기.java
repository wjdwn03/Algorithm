import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		Point[] arr = new Point[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			arr[i] = new Point(x, y);
		}

		Arrays.sort(arr);

		for (int i = 0; i < N; i++) {
			sb.append(arr[i].i).append(" ").append(arr[i].j).append("\n");
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