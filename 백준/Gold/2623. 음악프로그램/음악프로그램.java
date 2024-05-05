import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] degree;
	static List<Integer>[] list;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		degree = new int[N + 1];
		list = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int tmp = Integer.parseInt(st.nextToken());
			int before = Integer.parseInt(st.nextToken());

			for (int j = 1; j < tmp; j++) {
				int now = Integer.parseInt(st.nextToken());

				list[before].add(now);
				degree[now]++;

				before = now;
			}

		}

		topologicalSort();

		System.out.println(sb.toString());
	}

	private static void topologicalSort() {

		Queue<Integer> queue = new ArrayDeque<>();
		List<Integer> result = new ArrayList<>();

		int cnt = 0;

		for (int i = 1; i <= N; i++) {
			if (degree[i] == 0)
				queue.offer(i);
		}

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			cnt++;
			sb.append(cur).append("\n");

			for (int next : list[cur]) {

				if (--degree[next] == 0)
					queue.offer(next);

			}
		}

		if (cnt != N) {
			sb = new StringBuilder();
			sb.append("0");
		}

	}

}