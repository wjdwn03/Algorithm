import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int computer, twin, cnt;
	static List<Integer>[] list;
	static boolean[] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		computer = Integer.parseInt(br.readLine());
		twin = Integer.parseInt(br.readLine());
		visit = new boolean[computer + 1];
		cnt = 0;
		list = new ArrayList[computer + 1];

		StringTokenizer st;

		// 리스트 초기화
		for (int i = 0; i <= computer; i++) {
			list[i] = new ArrayList<>();
		}

		int from = 0, to = 0;

		for (int i = 0; i < twin; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(from);
		} // end input

		dfs(1);

		System.out.println(cnt);

	}

	private static void dfs(int cur) {

		visit[cur] = true;

		for (int i : list[cur]) {
			
			if (!visit[i]) {
				dfs(i);
				cnt++;
			}
			
		}

	}

}