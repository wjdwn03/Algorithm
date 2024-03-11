import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, K, ans;
	static int[][] arr;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Math.min(Integer.MAX_VALUE, Integer.parseInt(st.nextToken()));
			}
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
			}
		}

		visit = new boolean[N];
		visit[K] = true;
		ans = Integer.MAX_VALUE;

		getMinTime(K, 0);

		System.out.println(ans);
	}

	private static void getMinTime(int num, int cost) {

		boolean check = true;

		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				check = false;
				visit[i] = true;
				getMinTime(i, cost + arr[num][i]);
				visit[i] = false;
			}
		}

		if (check) {
			ans = Math.min(ans, cost);
		}

	}

}