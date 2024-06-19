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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N];

		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();

			int num = Integer.parseInt(br.readLine());

			list[i].add(num);
		}
		cnt = -1;

		bfs();

		System.out.println(cnt);
	}

	private static void bfs() {

		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visit = new boolean[N];

		queue.add(0);
		visit[0] = true;

		int count = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int s = 0; s < size; s++) {
				int now = queue.poll();

				if (now == M) {
					cnt = count;
					return;
				}

				for (int next : list[now]) {
					if (!visit[next]) {
						visit[next] = true;
						queue.offer(next);
					}
				}

				count++;
			}
		}

	}

}