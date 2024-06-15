import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int maxSum = -1;
		int maxNum = 0;

		for (int i = 1; i <= 5; i++) {
			st = new StringTokenizer(br.readLine());
			int sum = 0;
			for (int j = 0; j < 4; j++) {
				sum += Integer.parseInt(st.nextToken());
			}

			if (maxSum < sum) {
				maxSum = sum;
				maxNum = i;
			}
		}

		sb.append(maxNum).append(" ").append(maxSum);

		System.out.println(sb.toString());
	}

}