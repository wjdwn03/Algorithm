import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, min;
	static int[][] arr;
	static List<Point> list;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		arr = new int[N][M];

		list = new ArrayList<>();
		int zero = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
				// 익은 토마토를 리스트에 담아준다.
				if (arr[i][j] == 1)
					list.add(new Point(i, j));
                
                // 익지 않은 토마토 개수를 센다.
				if (arr[i][j] == 0)
					zero++;
			}
		} // end input

		
		int num = zero;
		
        // 익지 않은 토마토가 있는 경우에만 bfs를 호출한다.
		if(zero != 0) {
			num = bfs(0);
		}

		System.out.println(num);

	}

	private static int bfs(int cnt) {

		Queue<Point> queue = new ArrayDeque<>();

		// 모든 익은 토마토에서 동시에 출발해야 한다.
		// 그래서 처음에 큐에 일단 다 담는다.
		for (int i = 0; i < list.size(); i++) {

			queue.offer(new Point(list.get(i).i, list.get(i).j));
		}

		while (!queue.isEmpty()) {

			int size = queue.size();

			for (int s = 0; s < size; s++) {

				Point cur = queue.poll();

				for (int d = 0; d < 4; d++) {
					int nexti = cur.i + di[d];
					int nextj = cur.j + dj[d];

					if (nexti < 0 || nexti >= N || nextj < 0 || nextj >= M)
						continue;

					if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < M ) {
						if(arr[nexti][nextj] == 0 && arr[cur.i][cur.j] == 1) {
							arr[nexti][nextj] = 1;
							queue.offer(new Point(nexti, nextj));							
						}

					} // end if
				} // end for d
				
			} // end for s
			cnt++;
		} // end while

		boolean check = true;

		// 배열 전체 보면서 안 익은 토마토가 있는지 확인한다.
		for (int i = 0; i < N; i++) {

			check = true;

			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					check = false;
					break;
				}
			}

			// 만약 안 익은 토마토가 있다면 그냥 break 한다.
			if (!check)
				break;
		}

		if (check)
			return cnt-1; // 제일 마지막에 남은 0을 1로 바꾸고 나서 큐에 넣어버린다. 그래서 cnt가 1이 더 카운트 되기 때문에 -1 해줘야 한다.
		else
			return -1;

	} // end bfs


	static class Point {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

}