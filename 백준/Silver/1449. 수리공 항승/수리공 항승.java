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
		int L = Integer.parseInt(st.nextToken());

		double[] arr = new double[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Double.parseDouble(st.nextToken());
		}

		Arrays.sort(arr);

		int idx = 0;
		int cnt = 0;
		double tape = 0;

		while (idx < N) {

			if (arr[idx] + 0.5 > tape) {
				cnt++;
				tape = arr[idx] - 0.5 + L;

			}

			idx++;
		}

		System.out.println(cnt);
	}

}