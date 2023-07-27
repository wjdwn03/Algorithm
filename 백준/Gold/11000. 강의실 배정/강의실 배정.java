import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		Queue<Integer> pq = new PriorityQueue<>();

		Study[] arr = new Study[N];

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			arr[i] = new Study(start, end);

		} // end input

		Arrays.sort(arr);

		pq.add(arr[0].end);

		for (int i = 1; i < N; i++) {

			// 이미 큐에 있는 강의실에서 강의를 할 수 있는 경우
			if (pq.peek() <= arr[i].start) {

				// 끝난 강의는 제거
				pq.poll();
			}

			pq.add(arr[i].end);

		}

		System.out.println(pq.size());
	}

	static class Study implements Comparable<Study> {
		int start, end;

		public Study(int start, int end) {
			this.start = start;
			this.end = end;
		}

		// start 시간을 기준으로 하되 start가 같으면 end를 기준으로 정렬
		@Override
		public int compareTo(Study o) {

			if (this.start == o.start) {
				return this.end - o.end;
			} else {
				return this.start - o.start;
			}
		}
	}
}