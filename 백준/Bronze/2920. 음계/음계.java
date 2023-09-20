import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int size = st.countTokens();

		boolean up = false;
		boolean mix = false;

		int now = 0;
		int before = Integer.parseInt(st.nextToken());

		for (int i = 1; i < size; i++) {

			now = Integer.parseInt(st.nextToken());

			if (!up && before < now) {
				up = true;
			}

			else if (up && before > now) {
				sb.append("mixed");
				mix = true;
				break;
			}

			before = now;

		}

		if (!mix && up) {
			sb.append("ascending");
		} else if (!mix && !up) {
			sb.append("descending");
		}

		System.out.println(sb.toString());

	}

}