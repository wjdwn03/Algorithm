import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Point[] arr = new Point[8];

		int score = 0;

		for (int i = 0; i < 8; i++) {
			score = Integer.parseInt(br.readLine());

			arr[i] = new Point(i + 1, score);
		}

		Arrays.sort(arr);

		int sum = 0;
		int[] idxArr = new int[5];

		String tmp = "";

		for (int i = 0; i < 5; i++) {
			sum += arr[i].score;
			idxArr[i] = arr[i].idx;
		}

		Arrays.sort(idxArr);

		sb.append(sum).append("\n");

		for (int i = 0; i < 5; i++) {
			sb.append(idxArr[i]).append(" ");
		}

		System.out.println(sb.toString());

	}

	static class Point implements Comparable<Point> {
		int idx, score;

		public Point(int idx, int score) {
			this.idx = idx;
			this.score = score;
		}

		@Override
		public int compareTo(Point o) {
			return o.score - this.score;
		}
	}

}