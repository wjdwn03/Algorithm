import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int ans, N, M, one, two;
	static List<Integer>[] list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		one = Integer.parseInt(st.nextToken());
		two = Integer.parseInt(st.nextToken());

		M = Integer.parseInt(br.readLine());

		list = new ArrayList[N + 1];

		// list initialization
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			list[from].add(to);
			list[to].add(from);
		} // end input

		bfs();

		System.out.println(ans);
	}

	private static void bfs() {

		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visit = new boolean[N + 1];

		for (int i = 0; i < list[one].size(); i++) {
			queue.offer(list[one].get(i));
			visit[list[one].get(i)] = true;
		}

		boolean check = false;
		int now = 0;
		ans = 1;

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int s = 0; s < size; s++) {
				int cur = queue.poll();

				for (int i = 0; i < list[cur].size(); i++) {
					now = list[cur].get(i);

					if (visit[now])
						continue;

					queue.offer(now);
					visit[now] = true;

					if (now == two) {
						check = true;
					}
				}

				if (check)
					break;
			}

			ans++;

			if (check)
				break;
		}

		if (!check)
			ans = -1;
	}

}