import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		Map<Integer, Integer> map = new HashMap<>();

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			map.put(Integer.parseInt(st.nextToken()), 0);
		}

		int M = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());

		int now = 0;

		for (int i = 0; i < M; i++) {
			now = Integer.parseInt(st.nextToken());

			if (map.containsKey(now))
				sb.append("1");
			else
				sb.append("0");
			sb.append(" ");
		}
		System.out.println(sb.toString());
	}

}