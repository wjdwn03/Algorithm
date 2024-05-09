import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, R;
	static int[] order;
	static List<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		order = new int[N + 1];
		list = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			list[from].add(to);
			list[to].add(from);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(list[i]);
		}

		bfs();

		for (int i = 1; i <= N; i++) {
			sb.append(order[i]).append("\n");
		}

		System.out.println(sb.toString());
	}

	private static void bfs() {

		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visit = new boolean[N + 1];

		queue.offer(R);
		visit[R] = true;
		order[R] = 1;
		int num = 2;

		while (!queue.isEmpty()) {
			int cur = queue.poll();

			for (int next : list[cur]) {
				if (visit[next])
					continue;
				order[next] = num++;
				visit[next] = true;
				queue.offer(next);
			}
		}

	}

}