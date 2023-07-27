import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		Queue<Meeting> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			pq.add(new Meeting(start, end));

		} // end input

		Meeting before = pq.poll(); // 회의실 사용하고 있는 회의

		int cnt = 1; // 정답

		for (int i = 1; i < N; i++) {

			Meeting now = pq.poll();

			// now에 있는 회의 시간에 회의실이 비어있는 경우
			if (before.end <= now.start) {
				before = now;
				cnt++;
			}
		}

		System.out.println(cnt);
	}

	static class Meeting implements Comparable<Meeting> {
		int start, end;

		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		// end 시간을 기준으로 하되 end가 같으면 start를 기준으로 정렬
		@Override
		public int compareTo(Meeting o) {

			if (this.end == o.end) {
				return this.start - o.start;
			} else {
				return this.end - o.end;
			}
		}
	}
}