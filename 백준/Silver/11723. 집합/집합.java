import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int M = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());

			String order = st.nextToken();
			int num = 0;
			if (st.hasMoreTokens()) {
				num = Integer.parseInt(st.nextToken());
			}

			if (order.equals("add")) {
				map.put(num, 0);
			} else if (order.equals("remove")) {
				if (map.containsKey(num)) {
					map.remove(num);
				}
			} else if (order.equals("check")) {
				if (map.containsKey(num)) {
					sb.append(1);
				} else {
					sb.append(0);
				}
				sb.append("\n");
			} else if (order.equals("toggle")) {
				if (map.containsKey(num)) {
					map.remove(num);
				} else {
					map.put(num, 0);
				}
			} else if (order.equals("all")) {
				map.clear();
				for (int i = 1; i < 21; i++) {
					map.put(i, 0);
				}
			} else { // "empty"
				map.clear();
			}
		} // end for m

		System.out.println(sb.toString());
	}

}