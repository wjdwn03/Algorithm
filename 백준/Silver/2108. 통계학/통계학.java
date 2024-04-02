import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Frequency implements Comparable<Frequency> {
	int num, cnt;

	public Frequency(int num, int cnt) {
		this.num = num;
		this.cnt = cnt;
	}

	@Override
	public int compareTo(Frequency o) {
		if (this.cnt == o.cnt)
			return this.num - o.num;
		return o.cnt - this.cnt;
	}
}

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		HashMap<Integer, Integer> map = new HashMap<>(); // 빈도수 체크용
		int sum = 0, min = 4000, max = -4000;

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());

			sum += arr[i];

			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);

			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else
				map.put(arr[i], 1);
		}

		List<Frequency> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			if (map.containsKey(arr[i])) {
				list.add(new Frequency(arr[i], map.get(arr[i])));
				map.remove(arr[i]);
			}
		}

		Collections.sort(list);
		Arrays.sort(arr);

		sb.append(Math.round((double) sum / N)).append("\n");
		sb.append(arr[N / 2]).append("\n");

		if (list.size() > 1 && list.get(0).cnt == list.get(1).cnt) {
			sb.append(list.get(1).num).append("\n");
		} else {
			sb.append(list.get(0).num).append("\n");
		}
		sb.append(max - min);

		System.out.println(sb.toString());
	}

}