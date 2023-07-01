import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] num;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			num = new int[M + 1][N + 1]; // M개 중에 N개를 선택하려고 한다.
			
			// 1개로 n개 선택하는 경우의 수는 n이다.
			for(int i=0; i<=N; i++) {
				num[1][i] = i;
			}

			int ans = comb(M, N);
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int comb(int n, int r) {

		if (num[n][r] != 0)
			return num[n][r];
		
		// 아예 선택하지 않는 것도 하나의 경우이다. 아마도?
		if (r == 0)
			return 1;
		
		// n과 r이 같은 경우 n개 중에 r개를 선택하는 경우의 수는 1이다.
		if (n == r) {
			return 1;
		} else {
			num[n][r] = comb(n - 1, r - 1) + comb(n - 1, r); // r을 포함해서 선택하는 경우 + r을 제외하고 선택하는 경우
			return num[n][r];
		}

	}

}