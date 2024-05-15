import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		String name = st.nextToken();
		int age = Integer.parseInt(st.nextToken());
		int weight = Integer.parseInt(st.nextToken());

		while (!name.equals("#") && age != 0 && weight != 0) {

			sb.append(name).append(" ");

			if (age > 17 || weight >= 80) {
				sb.append("Senior");
			} else {
				sb.append("Junior");
			}

			sb.append("\n");

			st = new StringTokenizer(br.readLine());

			name = st.nextToken();
			age = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
		}

		System.out.println(sb.toString());
	}

}