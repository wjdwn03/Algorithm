import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		String color = br.readLine();

		int Rcnt = 0, Bcnt = 0;
		int ans = 1; // 모두 한 가지 색으로 칠할 수도 있으니 ans의 값을 1로 초기화함.

		List<Point>[] list = new ArrayList[26];
		int b = 1; // B 인덱스
		int r = 'R' - 'A'; // R의 인덱스

		// 초기화
		for (int i = 0; i < 26; i++) {
			list[i] = new ArrayList<>();
		}

		int startIdx = 0; // 같은 색 시작 index
		int endIdx = 0; // 같은 색 끝 index

		if (color.charAt(0) == 'B') {
			Bcnt++;
		} else {
			Rcnt++;
		}

		for (int i = 1; i < N; i++) {

			int now = color.charAt(i) - 'A';
			int before = color.charAt(i - 1) - 'A';

			// 다른 색이 나온 경우
			if (now != before) {
				endIdx = i - 1;
				list[before].add(new Point(startIdx, endIdx));
				startIdx = i;
			}

			if (i == N - 1) {
				if (now == before) {
					endIdx = N - 1;
					list[now].add(new Point(startIdx, endIdx));
				} else {
					list[now].add(new Point(i, i));
				}
			}

			switch (now) {
			case 1:
				Bcnt++;
				break;
			default:
				Rcnt++;
				break;
			}

		} // end for

		int minColor = 0;

		if (Bcnt != 0 && Rcnt != 0) {

			// 칠해야하는 조각이 더 많은 색을 먼저 칠해야 최솟값이 나온다.
			if (list[b].size() > list[r].size()) {
				minColor = r;
			} else {
				minColor = b;
			}
			ans += list[minColor].size();
		}

		System.out.println(ans);

	}

	static class Point {
		int start, end;

		public Point(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

}