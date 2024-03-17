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
		int c = Integer.parseInt(st.nextToken());

		int max = 0; // 가장 긴 변
		int sum = 0; // 나머지 두변의 길이 합
		int cnt = 0; // 길이가 같은 변의 개수

		while (a != 0 && b != 0 && c != 0) {

			max = 0;
			sum = 0;

			if (max < a) {
				max = a;
				sum = b + c;
			}
			if (max < b) {
				max = b;
				sum = a + c;
			}
			if (max < c) {
				max = c;
				sum = a + b;
			}

			if (max >= sum) {
				sb.append("Invalid");
			}

			else {
				cnt = 0;

				if (a == b)
					cnt++;
				if (b == c)
					cnt++;
				if (a == c)
					cnt++;

				if (cnt == 3) {
					sb.append("Equilateral");
				} else if (cnt == 1) {
					sb.append("Isosceles");
				} else {
					sb.append("Scalene");
				}
			}

			sb.append("\n");

			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
		} // end while

		System.out.println(sb.toString());
	}

}