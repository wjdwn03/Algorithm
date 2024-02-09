import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int A, B;
	static String ans; // 명령어
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());

			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			bfs();

		}

		System.out.println(sb.toString());
	}

	private static void bfs() {
		Queue<Order> queue = new ArrayDeque<>();
		boolean[] visit = new boolean[10000];

		queue.offer(new Order(A, ""));
		visit[A] = true;

		while (!queue.isEmpty()) {

			Order cur = queue.poll();

			if (cur.num == B) {
				sb.append(cur.str).append("\n");
				return;
			}

			int d = cur.num * 2 % 10000;
			int s = cur.num == 0 ? 9999 : cur.num - 1;
			int l = (cur.num % 1000) * 10 + cur.num / 1000;
			int r = cur.num / 10 + (cur.num % 10) * 1000;

			// 1번 명령어 D

			if (!visit[d]) {
				visit[d] = true;
				queue.offer(new Order(d, cur.str + "D"));
			}

			// 2번 명령어 S
			if (!visit[s]) {
				visit[s] = true;
				queue.offer(new Order(s, cur.str + "S"));
			}

			// 3번 명령어 L
			if (!visit[l]) {
				visit[l] = true;
				queue.offer(new Order(l, cur.str + "L"));
			}

			// 4번 명령어 R
			if (!visit[r]) {
				visit[r] = true;
				queue.offer(new Order(r, cur.str + "R"));
			}
		}

	}

	static class Order {
		int num;
		String str;

		public Order(int num, String str) {
			this.num = num;
			this.str = str;
		}
	}

}