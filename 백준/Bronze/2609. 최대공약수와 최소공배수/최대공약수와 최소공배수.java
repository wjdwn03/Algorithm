import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int max = Math.min(a, b); // 최대 공약수
		int min = 0; // 최소공배수

		for (int i = max; i > 0; i--) {
			if (a % i == 0 && b % i == 0) {
				max = i;
				min = (a / i) * (b / i) * i;
				break;
			}
		}

		sb.append(max).append("\n").append(min);

		System.out.println(sb.toString());
	}
}