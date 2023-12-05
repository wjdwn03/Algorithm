import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int ans, to;
	static boolean[] nonPrime;
	static boolean[] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		nonPrime = new boolean[10000];

		int tmp = 0;

		for (int i = 2; i < 10000; i++) {
			if (nonPrime[i])
				continue;

			if (i % 2 == 0) {
				nonPrime[i] = true;
				continue;
			}

			tmp = i * i;

			while (tmp < 10000) {
				nonPrime[tmp] = true;
				tmp += i;
			}
		}

		for (int t = 0; t < T; t++) {
			ans = Integer.MAX_VALUE;
			visit = new boolean[10000];
			int[] num = new int[4];

			st = new StringTokenizer(br.readLine());

			String from = st.nextToken();
			to = Integer.parseInt(st.nextToken());

			num[0] = from.charAt(0) - '0';
			num[1] = from.charAt(1) - '0';
			num[2] = from.charAt(2) - '0';
			num[3] = from.charAt(3) - '0';

			visit[Integer.parseInt(from)] = true;

			if (Integer.parseInt(from) == to) {
				ans = 0;
			} else {
				bfs(num);
			}

			sb.append(ans).append("\n");

		}

		System.out.println(sb.toString());
	}

	private static void bfs(int[] num) {

		Queue<Number> queue = new ArrayDeque<>();
		int[] visit = new int[10000];

		int start = arrayToInt(num);
		queue.add(new Number(start, 0));

		Arrays.fill(visit, Integer.MAX_VALUE);
		visit[start] = 0;

		while (!queue.isEmpty()) {
			Number cur = queue.poll();

			if (cur.num == to) {
				ans = cur.cnt;
				return;
			}

			int[] numArr = { cur.num / 1000, (cur.num / 100) % 10, (cur.num / 10) % 10, cur.num % 10 };

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 10; j++) {
					if (i == 0 && j == 0)
						continue;

					int tmp = numArr[i];
					numArr[i] = j;
					int next = arrayToInt(numArr);
					numArr[i] = tmp;

					if (nonPrime[next])
						continue;

					if (visit[next] >= cur.cnt + 1) {
						queue.offer(new Number(next, cur.cnt + 1));
						visit[next] = cur.cnt + 1;

					}
				}
			}
		}

	}

	static class Number {
		int num, cnt;

		public Number(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}

	private static int arrayToInt(int[] num) {
		return (num[0] * 1000) + (num[1] * 100) + (num[2] * 10) + num[3];
	}

}