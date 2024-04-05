import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String[] arr = br.readLine().split(",");

			sb.append(Integer.parseInt(arr[0]) + Integer.parseInt(arr[1])).append("\n");
		}

		System.out.println(sb.toString());

	}

}