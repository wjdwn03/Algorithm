import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
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

		int[] arr = new int[N + 1]; // 진입 차수 저장할 배열
		List<Integer>[] list = new ArrayList[N + 1];

		// 초기화
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list[a].add(b);
			arr[b]++;
		} // end input

		Queue<Integer> queue = new ArrayDeque<>();

		for (int i = 1; i <= N; i++) {
			if (arr[i] == 0)
				queue.add(i);
		}

		while (!queue.isEmpty()) {
			int cur = queue.poll();

			sb.append(cur).append(" ");

			for (int next : list[cur]) {
				if (--arr[next] == 0)
					queue.add(next);
			}
		}

		System.out.println(sb.toString());
	}

}