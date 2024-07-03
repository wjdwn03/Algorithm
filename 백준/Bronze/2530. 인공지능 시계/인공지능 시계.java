import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int h = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		int d = Integer.parseInt(br.readLine());

		// 초 계산
		s += d % 60;
		d -= d % 60;

		m += s / 60;
		s %= 60;

		// 분 계산

		m += d / 60;

		h += m / 60;
		m %= 60;

		// 시 계산
		h %= 24;

		sb.append(h).append(" ").append(m).append(" ").append(s);

		System.out.println(sb.toString());

	}

}