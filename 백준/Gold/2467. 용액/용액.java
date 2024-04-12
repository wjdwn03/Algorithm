import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int min = 2000000000;
		int start = 0, end = N - 1;
		int[] water = new int[2];
		water[0] = arr[start];
		water[1] = arr[end];

		while (start < end) {
			if (min >= Math.abs(arr[start] + arr[end])) {
				min = Math.abs(arr[start] + arr[end]);
				water[0] = arr[start];
				water[1] = arr[end];
			}

			if (Math.abs(arr[start]) <= Math.abs(arr[end]))
				end--;
			else
				start++;
		} // end while

		sb.append(water[0]).append(" ").append(water[1]);

		System.out.println(sb.toString());
	}

}