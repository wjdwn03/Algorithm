import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[N];
		int max = -1;

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		} // end input

		for (int i = 1; i < N; i++) {
			int gcd = cal(arr[0], arr[i]);

			sb.append(arr[0] / gcd).append("/").append(arr[i] / gcd);

			sb.append("\n");
		}

		System.out.println(sb);
	}

	static int cal(int a, int b) {
		int r;

		while (b != 0) {
			r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}