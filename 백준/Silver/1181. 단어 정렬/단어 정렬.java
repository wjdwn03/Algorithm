import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		Queue<String> pq = new PriorityQueue<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {

				if (o1.length() == o2.length()) {
					return o1.compareTo(o2);
				} else {
					return o1.length() - o2.length();
				}
			}
		});

		String word = "";

		for (int i = 0; i < N; i++) {
			word = br.readLine();
			if (!pq.contains(word)) {
				pq.add(word);
			}
		}

		while (!pq.isEmpty()) {
			sb.append(pq.poll()).append("\n");
		}

		System.out.println(sb.toString());
	}

}