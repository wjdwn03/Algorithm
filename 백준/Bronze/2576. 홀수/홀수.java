import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int min = 100;
		int sum = 0;

		for (int i = 0; i < 7; i++) {
			int num = Integer.parseInt(br.readLine());

			if ((num & 1) == 1) {
				sum += num;
				min = Math.min(min, num);
			}
		}

		if (min == 100) {
			sb.append(-1);
		} else {
			sb.append(sum).append("\n").append(min);
		}

		System.out.println(sb.toString());
	}

}