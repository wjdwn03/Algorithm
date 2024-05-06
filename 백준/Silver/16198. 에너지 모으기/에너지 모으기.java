import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Marble {
	int[] arr;
	int size, energy;

	public Marble(int[] arr, int size, int energy) {
		this.arr = arr;
		this.size = size;
		this.energy = energy;
	}
}

public class Main {

	static int N, max;
	static int[] origin;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		max = -1;
		origin = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			origin[i] = Integer.parseInt(st.nextToken());
		} // end input

		bfs();

		System.out.println(max);
	}

	private static void bfs() {

		Queue<Marble> queue = new ArrayDeque<>();

		for (int i = 1; i < N - 1; i++) {
			int[] arr = new int[N - 1];
			int idx = 0;

			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;
				arr[idx++] = origin[j];
			}

			queue.offer(new Marble(arr, N - 1, origin[i - 1] * origin[i + 1]));
		}

		while (!queue.isEmpty()) {
			Marble cur = queue.poll();

			if (cur.size == 2) {
				max = Math.max(max, cur.energy);
				continue;
			}

			for (int i = 1; i < cur.size - 1; i++) {
				int[] newArr = new int[cur.size - 1];
				int idx = 0;

				for (int j = 0; j < cur.size; j++) {
					if (i == j)
						continue;
					newArr[idx++] = cur.arr[j];
				}

				queue.offer(new Marble(newArr, cur.size - 1, cur.energy + cur.arr[i - 1] * cur.arr[i + 1]));
			}
		}

	}

}