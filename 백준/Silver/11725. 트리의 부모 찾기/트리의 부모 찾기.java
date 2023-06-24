import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static List<Integer>[] list;
	static int[] arr;
	static boolean[] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N + 1];
		arr = new int[N + 1];
		visit = new boolean[N + 1];

		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list[a].add(b);
			list[b].add(a);
		}
		visit[1] = true;
		dfs(1);

		for (int i = 2; i <= N; i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb.toString());

	}

	private static void dfs(int idx) {

		for (int i = 0; i < list[idx].size(); i++) {
			int now = list[idx].get(i);

			if (!visit[now]) {
				visit[now] = true;
				arr[now] = idx;
				dfs(now);
			}
		}

	}

}