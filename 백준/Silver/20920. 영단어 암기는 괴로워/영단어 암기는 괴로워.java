import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Dictionary implements Comparable<Dictionary> {
	int cnt, length;
	String word;

	public Dictionary(String word, int length, int cnt) {
		this.word = word;
		this.length = length;
		this.cnt = cnt;
	}

	@Override
	public int compareTo(Dictionary o) {
		if (o.cnt == this.cnt) {
			if (o.length == this.length) {
				return this.word.compareTo(o.word);
			}
			return Integer.compare(o.length, this.length);
		}
		return Integer.compare(o.cnt, this.cnt);
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < N; i++) {
			String input = br.readLine();

			if (input.length() < M)
				continue;

			if (map.containsKey(input))
				map.put(input, map.get(input) + 1);
			else
				map.put(input, 1);
		}

		String[] key = map.keySet().toArray(new String[map.size()]);
		Queue<Dictionary> pq = new PriorityQueue<>();

		for (String word : key) {
			pq.offer(new Dictionary(word, word.length(), map.get(word)));
		}

		while (!pq.isEmpty()) {
			sb.append(pq.poll().word).append("\n");
		}

		System.out.println(sb.toString());

	}

}