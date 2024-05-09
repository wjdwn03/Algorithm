import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, ans, min;
	static List<Integer>[] list;
	static int[][] distance;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = 100; // 케빈 베이컨의 수가 가장 작은 사람
		min = 10001; // 가장 작은 케빈 베이컨 수

		distance = new int[N + 1][N + 1];
		list = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list[a].add(b);
			list[b].add(a);
		}

		for (int i = 1; i <= N; i++) {

			bfs(i);

		}

		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 1; j <= N; j++) {
				if (i == j)
					continue;
				sum += distance[i][j];
			}

			if (sum < min) {
				min = sum;
				ans = i;
			}
		}

		System.out.println(ans);
	}

	private static void bfs(int start) {

		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visit = new boolean[N + 1];

		visit[start] = true;
		int dis = 0;
		queue.offer(start);

		while (!queue.isEmpty()) {
			int size = queue.size();

			dis++;

			for (int s = 0; s < size; s++) {
				int now = queue.poll();

				for (int next : list[now]) {
					if (!visit[next] || distance[start][next] == 0) {
						visit[next] = true;
						queue.offer(next);
						distance[start][next] = dis;
						distance[next][start] = dis;
					}
				}

			}

		}

	}

}