import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	static int S, min;
	static boolean[][] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		S = Integer.parseInt(br.readLine());
		min = Integer.MAX_VALUE;
		visit = new boolean[2001][2001]; // [화면 임티 수][클립보드 임티 수]

		bfs();

		System.out.println(min);
	}

	private static void bfs() {

		Queue<Point> queue = new ArrayDeque<>();

		queue.offer(new Point(1, 0, 0));
		visit[1][0] = true;

		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			if (cur.emoticon == S) {
				min = Math.min(min, cur.time);
				return;
			}

			if (cur.emoticon > 0 && cur.emoticon < 2000) {

				// copy
				if (!visit[cur.emoticon][cur.emoticon]) {
					visit[cur.emoticon][cur.emoticon] = true;
					queue.offer(new Point(cur.emoticon, cur.emoticon, cur.time + 1));
				}

				// delete
				if (!visit[cur.emoticon - 1][cur.clipboard]) {
					visit[cur.emoticon - 1][cur.clipboard] = true;
					queue.offer(new Point(cur.emoticon - 1, cur.clipboard, cur.time + 1));
				}

			}

			// paste
			if (cur.clipboard > 0 && cur.emoticon + cur.clipboard < 2000) {
				if (!visit[cur.emoticon + cur.clipboard][cur.clipboard]) {
					visit[cur.emoticon + cur.clipboard][cur.clipboard] = true;
					queue.offer(new Point(cur.emoticon + cur.clipboard, cur.clipboard, cur.time + 1));
				}
			}
		}

	}

	static class Point {
		int emoticon, clipboard, time;

		public Point(int emotcion, int clipboard, int time) {
			this.emoticon = emotcion;
			this.clipboard = clipboard;
			this.time = time;
		}
	}

}