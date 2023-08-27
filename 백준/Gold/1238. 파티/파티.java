import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, X, max, sum;
	static List<Point>[] list;
	static List<Point>[] reverseList;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		reverseList = new ArrayList[N + 1];
		max = -1;
		sum = 0;

		// initialization
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
			reverseList[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			sum += time;

			list[from].add(new Point(to, time));
			reverseList[to].add(new Point(from, time));
		}

		int[] arr1 = bfs(list);
		int[] arr2 = bfs(reverseList);

		for (int i = 1; i <= N; i++) {
			max = Math.max(max, arr1[i] + arr2[i]);
		}
		System.out.println(max);

	}

	private static int[] bfs(List<Point>[] list) {

		int[] arr = new int[N + 1];
		Arrays.fill(arr, sum);
		arr[X] = 0;

		Queue<Point> queue = new PriorityQueue<>();

		for (int i = 0; i < list[X].size(); i++) {
			arr[list[X].get(i).to] = Math.min(arr[list[X].get(i).to], list[X].get(i).time);
			queue.offer(new Point(X, list[X].get(i).to, list[X].get(i).time));
		}

		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			if (cur.time >= sum)
				continue;

			for (int i = 0; i < list[cur.to].size(); i++) {

				if (arr[list[cur.to].get(i).to] > arr[cur.to] + list[cur.to].get(i).time) {
					arr[list[cur.to].get(i).to] = arr[cur.to] + list[cur.to].get(i).time;
					queue.offer(new Point(cur.to, list[cur.to].get(i).to, arr[list[cur.to].get(i).to]));

				}
			}
		} // end while

		return arr;

	}

	static class Point implements Comparable<Point> {
		int from, to, time;
		boolean check;

		public Point(int to, int time) {
			this.to = to;
			this.time = time;
		}

		public Point(int from, int to, int time) {
			this.from = from;
			this.to = to;
			this.time = time;
		}

		@Override
		public int compareTo(Point o) {
			return this.time - o.time;
		}

	}

}