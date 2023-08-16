import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, C, M, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine());

		Delivery[] arr = new Delivery[M];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int box = Integer.parseInt(st.nextToken());

			arr[i] = new Delivery(from, to, box);
		} // end input

		Arrays.sort(arr);

		int cnt = 0;
		int max = 0;
		ans = 0;

		int[] truck = new int[N + 1];

		for (int i = 0; i < M; i++) {

			cnt = 0;
			max = 0;

			for (int j = arr[i].from; j < arr[i].to; j++) {

				if (max < truck[j]) {
					max = truck[j];
				}
			}
			
			cnt = Math.min(C - max, arr[i].box);

			for (int j = arr[i].from; j < arr[i].to; j++) {
				truck[j] += cnt;
			}
			
			ans += cnt;

		} // end for i

		System.out.println(ans);

	}

	static class Delivery implements Comparable<Delivery> {
		int from, to, box;

		public Delivery(int from, int to, int box) {
			this.from = from;
			this.to = to;
			this.box = box;
		}

		public int compareTo(Delivery o) {
			if (this.to == o.to) {
				return this.from - o.from;
			} else {
				return this.to - o.to;
			}
		}
	}

}