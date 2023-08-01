import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		int[] arr = new int[12];

		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;

		for (int i = 4; i < 12; i++) {
			arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
		}

		for (int t = 0; t < T; t++) {

			int n = Integer.parseInt(br.readLine());

			sb.append(arr[n]).append("\n");

		}

		System.out.println(sb.toString());
	}

}