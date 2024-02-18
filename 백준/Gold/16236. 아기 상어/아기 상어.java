import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, baby, cnt, time;
	static List<Point> list;
	static int[][] arr;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		baby = 2; // 아기 상어 크기
		cnt = 0; // 아기 상어가 먹은 물고기 수
		time = 0; // 이동 시간

		list = new LinkedList<>();
		arr = new int[N][N];

		int starti = 0, startj = 0; // 아기 상어의 시작 위치
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

				if (arr[i][j] == 9) {
					starti = i;
					startj = j;
					arr[i][j] = 0;
				}

				else if (arr[i][j] > 0 && arr[i][j] < 7) {
					list.add(new Point(i, j, arr[i][j]));
				}
			}
		} // end input

		// 아기 상어보다 작은 물고기를 쉽게 찾기 위해 정렬
		Collections.sort(list, (o1, o2) -> o1.weight - o2.weight);

		move(starti, startj);

		System.out.println(time);
	}

	private static void move(int starti, int startj) {

		Queue<Point> queue = new ArrayDeque<>();

		queue.offer(new Point(starti, startj));

		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			int size = list.size();

			PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {

				@Override
				public int compare(Point o1, Point o2) {
					if (o1.dis == o2.dis) {
						if (o1.i == o2.i)
							return o1.j - o2.j;
						return o1.i - o2.i;
					}
					return o1.dis - o2.dis;
				}
			});

			for (int i = 0; i < size; i++) {
				Point fish = list.get(i);

				if (fish.weight >= baby)
					break;

				int dis = getDistance(cur, fish);

				if (dis != -1)
					pq.offer(new Point(fish.i, fish.j, dis, i));

			}

			if (pq.isEmpty())
				return;

			Point eatenFish = pq.poll();

			// 잡아먹힌 물고기 제거 & 아기 상어 이동
			arr[eatenFish.i][eatenFish.j] = 0;
			list.remove(eatenFish.listIdx);
			time += eatenFish.dis;
			queue.offer(new Point(eatenFish.i, eatenFish.j));

			// 아기 상어 성장
			if (baby == ++cnt) {
				baby++;
				cnt = 0;
			}

		} // end while

	}

	private static int getDistance(Point babyShark, Point fish) {
		Queue<Point> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
		boolean[][] visit = new boolean[N][N];

		pq.offer(new Point(babyShark.i, babyShark.j, 0));
		visit[babyShark.i][babyShark.j] = true;

		int result = -1;

		while (!pq.isEmpty()) {
			Point cur = pq.poll();

			if (cur.i == fish.i && cur.j == fish.j) {
				return result = cur.weight;
			}
			for (int d = 0; d < 4; d++) {
				int nexti = cur.i + di[d];
				int nextj = cur.j + dj[d];

				if (nexti < 0 || nexti >= N || nextj < 0 || nextj >= N || arr[nexti][nextj] > baby
						|| visit[nexti][nextj])
					continue;

				visit[nexti][nextj] = true;
				pq.offer(new Point(nexti, nextj, cur.weight + 1));

			}
		}

		return result;
	}

	static class Point {
		int i, j, weight, dis, listIdx;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}

		public Point(int i, int j, int weight) {
			this.i = i;
			this.j = j;
			this.weight = weight;
		}

		public Point(int i, int j, int dis, int listIdx) {
			this.i = i;
			this.j = j;
			this.dis = dis;
			this.listIdx = listIdx;
		}
	}

}