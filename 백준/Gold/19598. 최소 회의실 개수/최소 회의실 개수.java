import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Point[] arr = new Point[N];
		Queue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			arr[i] = new Point(s, e);
		}

		Arrays.sort(arr);
		pq.add(arr[0].end);

		for (int i = 1; i < N; i++) {

			if (pq.peek() <= arr[i].start) {
				pq.poll();
			}
			pq.add(arr[i].end);
		}

		System.out.println(pq.size());

	}

	static class Point implements Comparable<Point> {
		int start, end;

		public Point(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Point o) {

			if (this.start == o.start) {
				return this.end - o.end;
			} else {
				return this.start - o.start;
			}

		}
	}

}