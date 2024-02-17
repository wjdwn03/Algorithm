import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, ans;
	static int[] arr; // 각 노드의 지름 저장할 배열
	static List<Node>[] list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		list = new ArrayList[N + 1];
		arr = new int[N + 1];

		// initialization
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		if (N == 1) {
			ans = 0;
		} else {

			for (int i = 0; i < N - 1; i++) {
				st = new StringTokenizer(br.readLine());
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());

				list[parent].add(new Node(child, weight));
			}

			ans = Integer.MIN_VALUE;

			dfs(1);
		}

		System.out.println(ans);

	}

	private static int dfs(int now) {

		if (list[now].isEmpty()) {
			return 0;
		}
		if (arr[now] == 0) {
			int sum = 0;
			int max = Integer.MIN_VALUE;
			int cnt = 0;

			Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));

			for (Node child : list[now]) {
				int tmp = child.weight + dfs(child.num);
				pq.add(tmp);
				max = Math.max(max, tmp);
			}

			while (!pq.isEmpty()) {
				sum += pq.poll();
				cnt++;
				if (cnt == 2)
					break;

			}
			// 자식들의 모든 경로의 합 중 가장 큰 값 2개를 합한 값이 정답
			ans = Math.max(ans, sum);

			// 자식 중 가장 큰 값을 return 해야 함.
			arr[now] = max;
		}

		return arr[now];

	}

	static class Node {
		int num, weight;

		public Node(int num, int weight) {
			this.num = num;
			this.weight = weight;
		}
	}

}