import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		Map<String, Integer> map = new TreeMap<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			String name = st.nextToken();
			String order = st.nextToken();

			if (order.equals("enter")) {
				map.put(name, 1);
			} else {
				map.remove(name);
			}
		}

		for (String name : map.keySet()) {
			sb.append(name).append("\n");
		}

		System.out.println(sb.toString());

	}

}