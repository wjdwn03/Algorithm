import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		TreeSet<Integer> set = new TreeSet<>();
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			set.add(num);
		}

		int size = set.size();
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < size; i++) {
			map.put(set.pollFirst(), i);
		}

		for (int i = 0; i < N; i++) {
			sb.append(map.get(arr[i])).append(" ");
		}
		System.out.println(sb.toString());

	}

}