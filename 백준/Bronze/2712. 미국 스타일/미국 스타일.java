import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());

			double num = Double.parseDouble(st.nextToken());
			String unit = st.nextToken();

			if (unit.equals("kg")) {
				sb.append(String.format("%.4f", num * 2.2046)).append(" ").append("lb");
			} else if (unit.equals("lb")) {
				sb.append(String.format("%.4f", num * 0.4536)).append(" ").append("kg");
			} else if (unit.equals("l")) {
				sb.append(String.format("%.4f", num * 0.2642)).append(" ").append("g");
			} else {
				sb.append(String.format("%.4f", num * 3.7854)).append(" ").append("l");
			}

			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

}