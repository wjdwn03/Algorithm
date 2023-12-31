import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] dp;
	static int[] T;
	static int[] P;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		dp = new int[N + 1];
		T = new int[N];
		P = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int time = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());

			T[i] = time;
			P[i] = price;
		}

		for (int i = 0; i < N; i++) {

			int time = i + T[i];

			if (time <= N) {
				dp[time] = Math.max(dp[time], dp[i] + P[i]);
			}

			dp[i + 1] = Math.max(dp[i + 1], dp[i]);
		}
		System.out.println(dp[N]);

	}

}