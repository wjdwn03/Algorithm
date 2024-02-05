import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));

		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());

			pq.add(x);

			if (x == 0) {
				sb.append(pq.poll()).append("\n");
			}
		}

		System.out.println(sb.toString());
	}

}