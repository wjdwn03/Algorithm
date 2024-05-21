import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int light = Integer.parseInt(st.nextToken());

		int ans = Math.max(-1, light - 0);
		int before = ans;

		for (int i = 1; i < M; i++) {
			light = Integer.parseInt(st.nextToken());
			if ((light - before) % 2 == 0)
				ans = Math.max(ans, (light - before) / 2);
			else
				ans = Math.max(ans, (light - before) / 2 + 1);
			before = light;
		}

		ans = Math.max(ans, N - before);

		System.out.println(ans);
	}

}