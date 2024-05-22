import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Work {

	int num, time;

	public Work(int num, int time) {
		this.num = num;
		this.time = time;
	}
}

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] topology = new int[N + 1]; // 진입차수
		int[] arr = new int[N + 1]; // 각 작업별로 완료 시간
		int[] timeArr = new int[N + 1]; // 작업별 수행 시간 input
		List<Work>[] list = new ArrayList[N + 1]; // 자식 작업

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>(); // initialization

			st = new StringTokenizer(br.readLine());

			int time = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());

			timeArr[i] = time; // 작업 수행 시간
			topology[i] = cnt; // 진입 차수

			for (int j = 0; j < cnt; j++) {
				int parent = Integer.parseInt(st.nextToken());

				list[parent].add(new Work(i, time));
			}
		} // end input

		// 위상정렬
		Queue<Integer> queue = new ArrayDeque<>();

		for (int i = 1; i <= N; i++) {
			if (topology[i] == 0) {
				queue.offer(i);
				arr[i] = timeArr[i];
			}
		}

		while (!queue.isEmpty()) {
			int cur = queue.poll();

			for (Work next : list[cur]) {

				arr[next.num] = Math.max(arr[next.num], arr[cur] + next.time);

				if (--topology[next.num] == 0) {
					queue.offer(next.num);
				}
			}
		}

		int ans = -1;
		
		// arr에 있는 값 중 가장 큰 값이 모든 작업을 완료하기 위한 최소 시간임.
		/*
		 *  7
			5 0
			1 0
			3 0
			6 0
			1 0
			8 0
			4 0
			
			위와 같은 경우 6번 작업이 8초에 만료되기 때문에 그보다 빠른 시간은 답이 아니다.
			따라서 arr에 저장된 값 중 가장 큰 값을 찾아야 함.
		 */
		for (int i = 1; i <= N; i++) {
			ans = Math.max(ans, arr[i]);
		}
		System.out.println(ans);

	}

}