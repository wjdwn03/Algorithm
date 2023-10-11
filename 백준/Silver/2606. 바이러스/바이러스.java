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
	static List<Integer>[] list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		list = new ArrayList[N + 1];

		// initialization
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		M = Integer.parseInt(br.readLine());

		int from = 0, to = 0;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());

			list[from].add(to);
			list[to].add(from);
		} // end input

		int cnt = bfs();

		System.out.println(cnt);

	}

	private static int bfs() {

		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visit = new boolean[N + 1];

		int size = list[1].size(); // 한 컴퓨터에 연결된 컴퓨터 개수
		int now = 0;
		int cnt = size;

		visit[1] = true;

		// 1번 컴퓨터에 연결된 컴퓨터 방문 체크 & 큐에 담기
		for (int i = 0; i < size; i++) {
			now = list[1].get(i);
			queue.offer(now);
			visit[now] = true;
		}

		while (!queue.isEmpty()) {
			int cur = queue.poll(); // 현재 컴퓨터 번호

			size = list[cur].size();

			// 연결된 모든 컴퓨터 중 방문하지 않은 컴퓨터를 방문처리
			for (int i = 0; i < size; i++) {
				now = list[cur].get(i);

				if (visit[now])
					continue;

				queue.offer(now);
				visit[now] = true;
				cnt++;

			}
		} // end while
		return cnt;

	} // end bfs

}