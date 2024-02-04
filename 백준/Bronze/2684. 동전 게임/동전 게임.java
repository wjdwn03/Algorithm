import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int P = Integer.parseInt(br.readLine());

		Map<String, Integer> map = new HashMap<>();

		for (int p = 0; p < P; p++) {
			map.clear();
			map.put("TTT", 0);
			map.put("TTH", 0);
			map.put("THT", 0);
			map.put("THH", 0);
			map.put("HTT", 0);
			map.put("HTH", 0);
			map.put("HHT", 0);
			map.put("HHH", 0);

			String input = br.readLine();

			for (int i = 0; i < 38; i++) {
				String now = input.substring(i, i + 3);
				int cnt = map.get(now);
				map.put(now, cnt + 1);
			}

			sb.append(map.get("TTT")).append(" ").append(map.get("TTH")).append(" ");
			sb.append(map.get("THT")).append(" ").append(map.get("THH")).append(" ");
			sb.append(map.get("HTT")).append(" ").append(map.get("HTH")).append(" ");
			sb.append(map.get("HHT")).append(" ").append(map.get("HHH")).append("\n");
		}

		System.out.println(sb.toString());
	}

}