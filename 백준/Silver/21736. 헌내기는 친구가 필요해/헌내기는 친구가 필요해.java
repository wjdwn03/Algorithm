import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, ans, peopleCnt;
	static char[][] map;
	static int[] di = { 1, -1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visit = new boolean[N][M];

		int starti = 0, startj = 0;
		ans = 0;

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
				if (map[i][j] == 'P')
					peopleCnt++;
				else if (map[i][j] == 'I') {
					starti = i;
					startj = j;
				}
			}
		} // end input

		visit[starti][startj] = true;
		dfs(starti, startj);

		if (ans == 0)
			System.out.println("TT");
		else
			System.out.println(ans);
	}

	private static void dfs(int nowi, int nowj) {

//		if (cnt == peopleCnt) {
//			return;
//		}

		for (int d = 0; d < 4; d++) {
			int nexti = nowi + di[d];
			int nextj = nowj + dj[d];

			if (nexti < 0 || nexti >= N || nextj < 0 || nextj >= M || visit[nexti][nextj] || map[nexti][nextj] == 'X')
				continue;

			visit[nexti][nextj] = true;

			if (map[nexti][nextj] == 'P') {
				ans++;
				if (ans == peopleCnt)
					return;
			}
			dfs(nexti, nextj);

		}
	}

}