import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static Medal[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new Medal[N];

		int num, gold, silver, bronze;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			num = Integer.parseInt(st.nextToken());
			gold = Integer.parseInt(st.nextToken());
			silver = Integer.parseInt(st.nextToken());
			bronze = Integer.parseInt(st.nextToken());

			arr[i] = new Medal(num, gold, silver, bronze);
		}

		Arrays.sort(arr, new Comparator<Medal>() {

			@Override
			public int compare(Medal o1, Medal o2) {
				if (o1.gold == o2.gold) {
					if (o1.silver == o2.silver) {
						return o2.bronze - o1.bronze;
					}
					return o2.silver - o1.silver;
				}

				return o2.gold - o1.gold;
			}
		});

		int rank = 1, same = 0;
		Medal before = arr[0];

		for (int i = 1; i < N; i++) {
			rank++;

			if (arr[i].gold == before.gold && arr[i].silver == before.silver && arr[i].bronze == before.bronze) {
				same++;
			}
			before = arr[i];

			if (arr[i].num == K)
				break;
		}

		System.out.println(rank - same);

	}

	static class Medal {
		int num, gold, silver, bronze;

		public Medal(int num, int gold, int silver, int bronze) {
			this.num = num;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
		}
	}

}