import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static StringBuilder sb;
	static boolean[] selected;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M];
		selected = new boolean[N + 1];

		perm(0);

		System.out.println(sb.toString());
	}

	private static void perm(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");

			return;
		}

		for (int i = 1; i <= N; i++) {

			if (selected[i])
				continue;

			arr[cnt] = i;

			selected[i] = true;
			perm(cnt + 1);
			selected[i] = false;
		}
	}

}