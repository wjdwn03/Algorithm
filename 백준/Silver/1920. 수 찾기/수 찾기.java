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

		int N = Integer.parseInt(br.readLine());

		HashMap<Integer, Integer> map = new HashMap<>();
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			map.put(Integer.parseInt(st.nextToken()), i);
		}

		int M = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			if (map.containsKey(Integer.parseInt(st.nextToken()))) {
				sb.append("1");
			} else {
				sb.append("0");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

}