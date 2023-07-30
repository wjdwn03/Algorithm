import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int V, E;
	static List<Integer>[] list;
	static int[] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int K = Integer.parseInt(br.readLine());

		for (int k = 0; k < K; k++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			list = new ArrayList[V + 1];
			visit = new int[V + 1];

			// 초기화
			for (int i = 0; i <= V; i++) {

				list[i] = new ArrayList<>();
			}

			for (int i = 0; i < E; i++) {

				st = new StringTokenizer(br.readLine());

				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				list[from].add(to);
				list[to].add(from);

			} // end input

			boolean check = true;

			for (int i = 1; i <= V; i++) {

				if (visit[i] == 0) {
					check = bfs(i);
				}

				if (!check) {
					break;
				}
			}

			if (check) {
				sb.append("YES").append("\n");
			} else {
				sb.append("NO").append("\n");
			}
		} // end for k

		System.out.println(sb.toString());
	}

	private static boolean bfs(int start) {

		Queue<Integer> queue = new ArrayDeque<>();

		visit[start] = 1;
		queue.offer(start);

		while (!queue.isEmpty()) {
			int cur = queue.poll();

			for (int i = 0; i < list[cur].size(); i++) {

				if (visit[cur] == visit[list[cur].get(i)]) {
					return false;
				}

				if (visit[list[cur].get(i)] == 0) {

					queue.offer(list[cur].get(i));

					if (visit[cur] == 1) {

						visit[list[cur].get(i)] = 2;

					} else if (visit[cur] == 2) {

						visit[list[cur].get(i)] = 1;

					}
				}
			}

		}
		return true;
	}

}