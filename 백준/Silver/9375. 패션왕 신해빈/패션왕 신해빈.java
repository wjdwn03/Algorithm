import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static int totalCnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {

			Map<String, Integer> map = new HashMap<>();
			int N = Integer.parseInt(br.readLine());
			totalCnt = 1;

			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				String name = st.nextToken();
				String type = st.nextToken();

				if (map.containsKey(type)) {
					map.put(type, map.get(type) + 1);
				} else {
					map.put(type, 1);
				}
			}

			for (int val : map.values()) {
				totalCnt *= (val + 1);
			}

			sb.append(totalCnt - 1).append("\n");
		}

		System.out.println(sb);
	}

}