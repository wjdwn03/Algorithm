import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];
		arr[1] = 1;

		if (n >= 2) {

			arr[2] = 2;

			int idx = 3;
			while (idx <= n) {
				arr[idx] = (arr[idx - 1] + arr[idx - 2]) % 10007;
				idx++;
			}

		} // end if

		System.out.println(arr[n]);

	}

}