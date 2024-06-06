import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

class Point implements Comparable<Point> {
	int i, j, dis, sol;

	public Point(int i, int j) {
		this.i = i;
		this.j = j;
	}

	public Point(int i, int j, int dis, int sol) {
		this.i = i;
		this.j = j;
		this.dis = dis;
		this.sol = sol;
	}

	@Override
	public int compareTo(Point o) {
		if (this.dis == o.dis)
			return Integer.compare(this.j, o.j);
		return Integer.compare(this.dis, o.dis);
	}
}

public class Main {

	static int N, M, D, ans, enemy;
	static int[] number;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end input

		ans = 0;
		number = new int[3];

		comb(0, 0);

		System.out.println(ans);
	}

	private static void comb(int cnt, int now) {

		if (cnt == 3) {

			int[][] copy = deepCopy();
			enemy = 0;

			for (int i = 0; i < N; i++) {
				// 공격
				copy = attack(copy, number);

				// 적 이동
				copy = move(copy);
			}

			ans = Math.max(ans, enemy);

			return;
		}

		for (int i = now; i < M; i++) {
			number[cnt] = i;
			comb(cnt + 1, i + 1);
		}

	}

	private static int[][] deepCopy() {
		int[][] copy = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy[i][j] = arr[i][j];
			}
		}
		return copy;
	}

	private static int[][] attack(int[][] arr, int[] soldier) {

		int cnt = 0;
		boolean[] soldierCheck = new boolean[M]; // 한 칸에 1명만 배치하기 위해 궁수 위치 확인
		Queue<Point> pq = new PriorityQueue<>();

        // D 거리 이하에 위치한 적 모두 큐에 추가
		for (int s : soldier) {
			for (int j = 0; j < M; j++) {
				int end = N - 1 - D < 0 ? -1 : N - 1 - D;
				for (int i = N - 1; i > end; i--) {

					int dis = Math.abs(i - N) + Math.abs(j - s);

					if (arr[i][j] == 1 && dis <= D) {
						pq.offer(new Point(i, j, dis, s));
					}
				}

			}
		}

		Set<String> set = new HashSet<>(); // 궁수가 동일한 적을 고를 수 있기 때문에 중복 제거용

        // 가장 가까우면서 j가 적은 위치 뽑기
		while (!pq.isEmpty()) {
			Point cur = pq.poll();

			if (soldierCheck[cur.sol])
				continue;
			soldierCheck[cur.sol] = true;
			set.add(String.valueOf(cur.i + " " + cur.j));

			if (set.size() == 3) {
				break;
			}
		}

        // 공격 처리
        int size = set.size();
		String[] attackedEnemy = set.toArray(new String[size]);

		for (String now : attackedEnemy) {

			StringTokenizer st = new StringTokenizer(now);

			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			arr[i][j] = 0;
		}

		enemy += size;

		return arr;
	}

	private static int[][] move(int[][] arr) {

		int[][] result = new int[N][M];

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < M; j++) {
				result[i][j] = arr[i - 1][j];
			}
		}

		return result;
	}

}