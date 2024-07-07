import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		String[] input = new String[N];
		Queue<String> ascDp = new PriorityQueue<>((o1, o2) -> o1.compareTo(o2));
		Queue<String> descDp = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));

		for (int i = 0; i < N; i++) {
			input[i] = br.readLine();

			ascDp.add(input[i]);
			descDp.add(input[i]);
		}

		boolean asc = true;
		boolean desc = true;

		int idx = 0;

		while (!ascDp.isEmpty()) {
			String now = ascDp.poll();

			if (!input[idx].equals(now)) {
				asc = false;
				break;
			}

			idx++;
		}

		if (!asc) {

			idx = 0;

			while (!descDp.isEmpty()) {
				String now = descDp.poll();

				if (!input[idx].equals(now)) {
					desc = false;
					break;
				}

				idx++;
			}
		}

		if (asc) {
			System.out.println("INCREASING");
		} else if (desc) {
			System.out.println("DECREASING");
		} else {
			System.out.println("NEITHER");
		}

	}

}