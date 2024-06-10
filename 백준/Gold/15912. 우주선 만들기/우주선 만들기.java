import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stW;
		StringTokenizer stE;

		int N = Integer.parseInt(br.readLine());
		long[] weight = new long[N + 1];
		long[] energy = new long[N + 1];
		long[] arr = new long[N + 1];
		long maxW = 0L, maxE = 0L;

		stW = new StringTokenizer(br.readLine());
		stE = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {

			weight[i] = Long.parseLong(stW.nextToken());
			energy[i] = Long.parseLong(stE.nextToken());
			arr[i] = arr[i - 1] + weight[i] * energy[i];

			maxW = weight[i];
			maxE = energy[i];

			for (int j = i; j > 0; j--) {
				maxW = Math.max(maxW, weight[j]);
				maxE = Math.max(maxE, energy[j]);
				arr[i] = Math.min(arr[i], arr[j - 1] + maxW * maxE);
			}

		} // end input

		System.out.println(arr[N]);
	}

}