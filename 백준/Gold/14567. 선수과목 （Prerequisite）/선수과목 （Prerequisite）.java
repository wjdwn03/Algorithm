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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] topology = new int[N + 1]; // 진입차수
		int[] arr = new int[N + 1]; // 학기
		List<Integer>[] list = new ArrayList[N + 1]; // 자식

		// initialization
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			topology[to]++;

			list[from].add(to);
		} // end Input

		// 위상정렬
		Queue<Integer> queue = new ArrayDeque<>();

		int time = 0;

		for (int i = 1; i <= N; i++) {
			if (topology[i] == 0)
				queue.add(i);
		}

		while (!queue.isEmpty()) {
			int size = queue.size();
			time++;

			for (int s = 0; s < size; s++) {
				int cur = queue.poll();
				arr[cur] = time;

				for (int next : list[cur]) {
					if (--topology[next] == 0)
						queue.add(next);
				}
			}

		}

		for (int i = 1; i <= N; i++) {
			sb.append(arr[i]).append(" ");
		}

		System.out.println(sb.toString());
	}

}