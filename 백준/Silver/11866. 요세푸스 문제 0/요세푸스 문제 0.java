import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		boolean[] visit = new boolean[N + 1];

		int cnt = 0;
		int idx = 0;

		int tmp = 0;

		sb.append("<");

		while (cnt < N) {

			idx++;

			if (idx > N) {
				idx -= N;
			}

			if (visit[idx])
				continue;

			tmp++;

			if (tmp == K) {

				visit[idx] = true;
				sb.append(idx).append(", ");
				cnt++;

				tmp = 0;
			}

		}

		int size = sb.length();
		sb.delete(size - 2, size);

		sb.append(">");

		System.out.println(sb.toString());

	}

}