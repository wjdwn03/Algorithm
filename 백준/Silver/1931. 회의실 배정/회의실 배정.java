import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		Meeting[] arr = new Meeting[N];

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			arr[i] = new Meeting(start, end);

		} // end input

		// end 시간을 기준으로 하되 end가 같으면 start를 기준으로 정렬
		Arrays.sort(arr);

		Meeting before = arr[0]; // 회의실 사용하고 있는 회의

		int cnt = 1; // 정답

		for (int i = 1; i < N; i++) {

			// arr[i]에 있는 회의 시간에 회의실이 비어있는 경우
			if (before.end <= arr[i].start) {
				before = arr[i];
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