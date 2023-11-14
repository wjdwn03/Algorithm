import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String input = br.readLine();

		Map<Character, Integer> map = new HashMap<>();

		// 모음 입력
		map.put('a', 1);
		map.put('e', 1);
		map.put('i', 1);
		map.put('o', 1);
		map.put('u', 1);
		map.put('A', 1);
		map.put('E', 1);
		map.put('I', 1);
		map.put('O', 1);
		map.put('U', 1);

		int cnt = 0, size = 0;

		while (!input.equals("#")) {
			cnt = 0;
			size = input.length();

			for (int i = 0; i < size; i++) {
				// 모음이 있으면 개수 증가
				if (map.containsKey(input.charAt(i)))
					cnt++;
			}

			sb.append(cnt).append("\n");

			input = br.readLine();
		}

		System.out.println(sb.toString());

	}

}