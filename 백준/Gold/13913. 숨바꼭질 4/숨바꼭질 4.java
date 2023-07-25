import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] di = { -1, 1, 2 };
	static int min;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();// 정답 경로

		parent = new int[100001]; // 이전 위치 저장

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		min = Integer.MAX_VALUE; // 최소 시간

		bfs(N, K);

		int idx = K;
		Deque<Integer> stack = new ArrayDeque<>();

		while (idx != N) {
			stack.push(idx);
			idx = parent[idx];
		}

		stack.push(N);

		sb.append(min).append("\n");

		while (!stack.isEmpty()) {
			sb.append(stack.poll()).append(" ");
		}

		System.out.println(sb.toString());

	}

	private static void bfs(int n, int k) {

		Queue<Point> queue = new PriorityQueue<>();
		boolean[] visit = new boolean[100001];

		visit[n] = true;
		queue.offer(new Point(n, 0));

		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			// min을 초과한 경우 더이상 볼 필요 없다.
			if (cur.cnt >= min) {
				continue;
			}

			// 동생이 있는 곳까지 간 경우
			if (cur.location == k) {

				min = Math.min(min, cur.cnt);

				return;
			}

			for (int d = 0; d < 3; d++) {
				int next = 0;

				if (d == 2) {
					next = cur.location * di[d];

				} else {
					next = cur.location + di[d];
				}

				// 범위를 벗어나거나 방문한 적 있으면 더이상 볼 필요 없다.
				if (next < 0 || next > 100000 || visit[next])
					continue;

				visit[next] = true;
				parent[next] = cur.location;

				queue.offer(new Point(next, cur.cnt + 1));
			}
		}

	}

	static class Point implements Comparable<Point> {
		int location, cnt;

		public Point(int location, int cnt) {
			this.location = location;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Point o) {

			return this.cnt - o.cnt;
		}
	}

}