import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, r, c;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		int len = (int) Math.pow(2, N);
		cnt = 0;

		z(len, r, c);

		System.out.println(cnt);
	}

	private static void z(int len, int r, int c) {

		if (len == 1)
			return;

		if (r < len / 2 && c < len / 2) {
			z(len / 2, r, c);
		}

		else if (r < len / 2 && c >= len / 2) {

			cnt += len * len / 4;
			z(len / 2, r, c - len / 2);
		}

		else if (r >= len / 2 && c < len / 2) {

			cnt += (len * len / 4) * 2;
			z(len / 2, r - len / 2, c);
		}

		else if (r >= len / 2 && c >= len / 2) {

			cnt += (len * len / 4) * 3;
			z(len / 2, r - len / 2, c - len / 2);

		}

	}

}