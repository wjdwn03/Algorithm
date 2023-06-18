import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N + 1];
		int i = 0, j = 0, k = 0;

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			Arrays.fill(arr, i, j + 1, k);
		}

		for (int idx = 1; idx <= N; idx++) {
			System.out.print(arr[idx] + " ");
		}
	}

}