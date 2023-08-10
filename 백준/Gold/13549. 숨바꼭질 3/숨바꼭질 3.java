import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int ans, N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		ans = 100000;

		bfs();

		System.out.println(ans);

	}

	public static void bfs() {
		Queue<Subin> queue = new ArrayDeque<>();

		int[] visit = new int[150000];

		Arrays.fill(visit, Integer.MAX_VALUE);

		queue.offer(new Subin(N, 0));
		visit[N] = 0;

		while (!queue.isEmpty()) {
			Subin cur = queue.poll();

			if (cur.time >= ans || cur.idx >= 150000)
				continue;

			if (cur.idx == K) {
				ans = Math.min(ans, cur.time);
				continue;
			}

			// x*2
			if (cur.idx > 0 && cur.idx * 2 < 150000 && visit[cur.idx * 2] > cur.time) {
				visit[cur.idx * 2] = cur.time;
				queue.offer(new Subin(cur.idx * 2, cur.time));
			}
			// x+1
			if (cur.idx + 1 >= 0 && cur.idx + 1 < 150000 && visit[cur.idx + 1] > cur.time + 1) {
				visit[cur.idx + 1] = cur.time + 1;
				queue.offer(new Subin(cur.idx + 1, cur.time + 1));
			}
			// x-1
			if (cur.idx - 1 >= 0 && cur.idx - 1 < 150000 && visit[cur.idx - 1] > cur.time + 1) {
				visit[cur.idx - 1] = cur.time + 1;
				queue.offer(new Subin(cur.idx - 1, cur.time + 1));
			}

		}

	}

	static class Subin {
		int idx, time;

		public Subin(int idx, int time) {
			this.idx = idx;
			this.time = time;
		}

	}

}