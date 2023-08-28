import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int[] v;
	static int[] w;
	static int[][] bag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		v = new int[N + 1];
		w = new int[N + 1];
		bag = new int[N + 1][K + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				if (w[i] > j) {
					bag[i][j] = bag[i - 1][j];
				} else {
					bag[i][j] = Math.max(bag[i - 1][j], v[i] + bag[i - 1][j - w[i]]);
				}

			}
		}

		System.out.println(bag[N][K]);
	}

}