import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		Town[] town = new Town[N];
		long sum = 0L;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int idx = Integer.parseInt(st.nextToken());
			int people = Integer.parseInt(st.nextToken());

			town[i] = new Town(idx, people);
			sum += people;
		}

		Arrays.sort(town);

		long nowPeople = 0L;
		int ans = 0;

		for (int i = 0; i < N; i++) {

			nowPeople += town[i].people;

			if ((sum + 1) / 2 <= nowPeople) {
				ans = town[i].idx;
				break;
			}

		} // end for i

		System.out.println(ans);

	}

	static class Town implements Comparable<Town> {
		int idx, people;

		public Town(int idx, int people) {
			this.idx = idx;
			this.people = people;
		}

		@Override
		public int compareTo(Town o) {

			return this.idx - o.idx;
		}

	}

}