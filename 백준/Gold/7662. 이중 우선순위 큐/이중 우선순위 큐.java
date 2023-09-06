import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {

			int K = Integer.parseInt(br.readLine());

			TreeMap<Integer, Integer> map = new TreeMap<>();

			for (int k = 0; k < K; k++) {

				st = new StringTokenizer(br.readLine());

				char cal = st.nextToken().charAt(0);
				int num = Integer.parseInt(st.nextToken());

				if (cal == 'I') {

					map.put(num, map.getOrDefault(num, 0) + 1);
				} else if (map.isEmpty()) {
					continue;
				} else {

					int cnt = 0;
					int key = 0;

					if (num < 0) {

						key = map.firstKey();
						cnt = map.get(key);

						if (cnt == 1) {
							map.remove(key);
						} else {
							map.put(key, cnt - 1);
						}

					} else {

						key = map.lastKey();
						cnt = map.get(key);

						if (cnt == 1) {
							map.remove(key);
						} else {
							map.put(key, cnt - 1);
						}
					}
				}

			} // end for k

			if (map.isEmpty()) {
				sb.append("EMPTY").append("\n");
			} else {
				sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
			}

		} // end for t

		System.out.println(sb.toString());
	}

}