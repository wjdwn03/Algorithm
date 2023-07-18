import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		} // end input

		Arrays.sort(arr);

		// int 최대값보다 큰 값이 나올 가능성이 있다.
		long ans = 0;

		for (int i = N - 1; i >= 0; i--) {

			long tip = arr[i] - (N - 1 - i);

			if (tip > 0) {
				ans += tip;
			}
		}

		System.out.println(ans);
	}

}