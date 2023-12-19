import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static boolean[] sight;
	static List<Point>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		sight = new boolean[N];
		list = new ArrayList[N];

		int a = 0, b = 0;
		long t = 0L;

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			// 초기화
			list[i] = new ArrayList<>();

			sight[i] = Integer.parseInt(st.nextToken()) == 0 ? false : true;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			t = Long.parseLong(st.nextToken());

			list[a].add(new Point(b, t));
			list[b].add(new Point(a, t));
		}

		long ans = bfs();

		System.out.println(ans);
	}

	private static long bfs() {

		Queue<Point> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.time, o2.time));

		long[] arr = new long[N];
		Arrays.fill(arr, Long.MAX_VALUE);
		arr[0] = 0;
		pq.offer(new Point(0, 0));
		int size = 0;

		while (!pq.isEmpty()) {
			Point cur = pq.poll();

			if ((cur.num != N - 1 && sight[cur.num]) || arr[cur.num] < cur.time)
				continue;

			size = list[cur.num].size();

			for (int i = 0; i < size; i++) {
				Point next = list[cur.num].get(i);

				if ((next.num != N - 1 && sight[next.num]) || arr[next.num] <= cur.time + next.time)
					continue;
				arr[next.num] = Math.min(arr[next.num], cur.time + next.time);
				pq.offer(new Point(next.num, arr[next.num]));
			}
		} // end while

		if (arr[N - 1] == Long.MAX_VALUE) {
			return -1L;
		} else {
			return arr[N - 1];
		}

	}

	static class Point {
		int num;
		long time;

		public Point(int num, long time) {
			this.num = num;
			this.time = time;
		}
	}

}