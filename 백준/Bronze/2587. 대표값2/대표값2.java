import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int[] arr = new int[5];

		int avg = 0;

		for (int i = 0; i < 5; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			avg += arr[i];
		}

		avg /= 5;

		Arrays.sort(arr);

		sb.append(avg).append("\n").append(arr[2]);

		System.out.println(sb.toString());

	}

}