import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, min;
	static int[][] arr;
	static boolean[] isSelected;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		min = Integer.MAX_VALUE;

		arr = new int[N][N];
		isSelected = new boolean[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end input

		powerset(0);

		System.out.println(min);

	}

	private static void powerset(int cnt) {

		if (cnt == N) {

			int a = 1;
			int b = 1;

			List<Integer> teamA = new ArrayList<>();
			List<Integer> teamB = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					teamA.add(i);
				} else {
					teamB.add(i);
				}
			}

			if (teamA.isEmpty() || teamB.isEmpty())
				return;

			if (teamA.size() >= 1) {

				a = 0;

				for (int i = 0; i < teamA.size(); i++) {

					int idx1 = teamA.get(i);

					for (int j = 0; j < teamA.size(); j++) {

						int idx2 = teamA.get(j);

						if (idx1 == idx2)
							continue;

						a += arr[idx1][idx2];
					}
				}
			}

			if (teamB.size() >= 1) {

				b = 0;

				for (int i = 0; i < teamB.size(); i++) {

					int idx1 = teamB.get(i);

					for (int j = 0; j < teamB.size(); j++) {

						int idx2 = teamB.get(j);

						if (idx1 == idx2)
							continue;

						b += arr[idx1][idx2];
					}
				}
			}

			min = Math.min(min, Math.abs(a - b));

			return;
		}

		isSelected[cnt] = true;
		powerset(cnt + 1);
		isSelected[cnt] = false;
		powerset(cnt + 1);

	}

}