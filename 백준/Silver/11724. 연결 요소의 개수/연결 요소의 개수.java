import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, cnt;
	static List<Integer>[] list;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		visit = new boolean[N + 1];

		// 초기화
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			list[u].add(v);
			list[v].add(u);
		} // end input

		for (int i = 1; i <= N; i++) {
			if (!visit[i]) {
				bfs(i);
			}
		}

		System.out.println(cnt);

	}

	private static void bfs(int now) {

		Queue<Integer> queue = new ArrayDeque<>();

		visit[now] = true;
		queue.offer(now);

		while (!queue.isEmpty()) {
			int cur = queue.poll();

			for (int i = 0; i < list[cur].size(); i++) {

				if (visit[list[cur].get(i)]) {
					continue;
				}

				visit[list[cur].get(i)] = true;
				queue.offer(list[cur].get(i));
			}
		} // end while

		cnt++;

	}

}