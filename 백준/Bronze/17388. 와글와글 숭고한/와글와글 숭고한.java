import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int soong = Integer.parseInt(st.nextToken());
		int korea = Integer.parseInt(st.nextToken());
		int hanyang = Integer.parseInt(st.nextToken());

		if (soong + korea + hanyang >= 100) {
			sb.append("OK");
		} else {
			int min = Math.min(Math.min(soong, korea), hanyang);

			if (min == soong) {
				sb.append("Soongsil");
			} else if (min == korea) {
				sb.append("Korea");
			} else {
				sb.append("Hanyang");
			}
		}

		System.out.println(sb.toString());

	}

}