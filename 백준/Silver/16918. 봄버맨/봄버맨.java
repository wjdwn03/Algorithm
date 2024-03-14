import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R, C, N;
	static char[][] bomb; // 격자판
	static int[][] times; // 격자판에 폭탄이 설치된 시간을 저장할 배열
	static int[] di = { 1, -1, 0, 0 };
	static int[] dj = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		bomb = new char[R][C];
		times = new int[R][C];

		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				bomb[i][j] = input.charAt(j);
			}
		} // end input

		// 짝수 초일때는 무조건 폭탄을 전부 채움.
		if (N % 2 == 0) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					sb.append("O");
				}
				sb.append("\n");
			}
		} else {
			int time = 1;

			while (++time <= N) {

				// 짝수 - 폭탄 채우기
				if (time % 2 == 0) {
					putBomb(time);
				}
				// 홀수 - 3초전에 설치한 폭탄과 상하좌우 폭탄 제거
				else {
					deleteBomb(time);
				}
			}

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					sb.append(bomb[i][j]);
				}
				sb.append("\n");
			}
		}

		System.out.println(sb.toString());
	}

	private static void deleteBomb(int time) {

		Queue<Point> queue = new ArrayDeque<>();

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (bomb[i][j] == 'O' && times[i][j] == time - 3) {

					queue.offer(new Point(i, j));

				}
			}
		}

		while (!queue.isEmpty()) {

			Point cur = queue.poll();

			bomb[cur.i][cur.j] = '.';

			for (int d = 0; d < 4; d++) {
				int nexti = cur.i + di[d];
				int nextj = cur.j + dj[d];

				if (nexti < 0 || nexti >= R || nextj < 0 || nextj >= C)
					continue;

				bomb[nexti][nextj] = '.';
			}
		}

	}

	private static void putBomb(int time) {

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (bomb[i][j] == '.') {
					bomb[i][j] = 'O';
					times[i][j] = time;
				}
			}
		}

	}

}

class Point {
	int i, j;

	public Point(int i, int j) {
		this.i = i;
		this.j = j;
	}
}