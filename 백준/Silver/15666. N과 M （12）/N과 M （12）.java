import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	static int N, M;
	static int[] input;
	static int[] num;
	static Map<String, Integer> map;
	static List<String> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		input = new int[N];
		num = new int[M];
		map = new HashMap<>(); // 수열 저장할 map -> 중복 체크용

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(input);

		list = new ArrayList<>(); // 수열 저장할 list

		comb(0, 0);

		for (String now : list) {
			sb.append(now).append("\n");
		}

		System.out.println(sb.toString());

	}

	private static void comb(int start, int cnt) {

		if (cnt == M) {

			String str = "";

			for (int i = 0; i < M; i++) {
				str += num[i] + " ";
			}

			if (!map.containsKey(str)) {
				list.add(str);
				map.put(str, 0);
			}
			return;
		}

		for (int i = start; i < N; i++) {
			num[cnt] = input[i];
			comb(i, cnt + 1);
		}

	}

}