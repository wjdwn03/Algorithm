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

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		list = new ArrayList[N + 1];
		cnt = 0;

		// initialization
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list[a].add(b);
			list[b].add(a);
		} // end input

		bfs();

		System.out.println(cnt);
	}

	private static void bfs() {

		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visit = new boolean[N + 1];

		int depth = 0;
		queue.add(1);
		visit[1] = true;

		while (!queue.isEmpty()) {

			int size = queue.size();
			for (int s = 0; s < size; s++) {

				int cur = queue.poll();

				for (int next : list[cur]) {
					if (!visit[next]) {
						visit[next] = true;
						queue.add(next);
						cnt++;
					}
				}
			} // end for s

			if (++depth > 1)
				return;
		} // end while

	}
}