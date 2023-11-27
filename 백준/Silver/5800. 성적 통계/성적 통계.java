import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int K = Integer.parseInt(br.readLine());

		for (int k = 1; k <= K; k++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());

			int[] arr = new int[x];

			int maxGap = 0;

			for (int i = 0; i < x; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr);

			for (int i = 1; i < x; i++) {
				maxGap = Math.max(maxGap, arr[i] - arr[i - 1]);
			}

			sb.append("Class ").append(k).append("\n").append("Max ").append(arr[x - 1]);
			sb.append(", Min ").append(arr[0]).append(", Largest gap ").append(maxGap).append("\n");
		}

		System.out.println(sb.toString());
	}

}