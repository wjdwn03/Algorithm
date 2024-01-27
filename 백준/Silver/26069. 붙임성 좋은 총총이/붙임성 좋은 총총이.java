import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		HashMap<String, Integer> map = new HashMap<>();

		map.put("ChongChong", 1);

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			String a = st.nextToken();
			String b = st.nextToken();

			if (map.containsKey(a)) {
				map.put(b, 1);
			} else if (map.containsKey(b)) {
				map.put(a, 1);
			}
		}

		System.out.println(map.size());
	}

}