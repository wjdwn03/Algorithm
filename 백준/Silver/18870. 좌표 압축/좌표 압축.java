import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int[] origin = new int[N];
		TreeSet<Integer> set = new TreeSet<>(); // 중복이 제거 + 정렬
		Map<Integer, Integer> map = new HashMap<>(); // 중복 제거하고 정렬된 좌표의 index를 저장할 map

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			origin[i] = Integer.parseInt(st.nextToken());
			set.add(origin[i]);
		}

		int idx = 0;

		// 중복 제거하고 정렬된 좌표의 index 담기
		while (!set.isEmpty()) {
			map.put(set.pollFirst(), idx++);
		}

		for (int i = 0; i < N; i++) {
			sb.append(map.get(origin[i])).append(" ");
		}

		System.out.println(sb.toString());

	}

}