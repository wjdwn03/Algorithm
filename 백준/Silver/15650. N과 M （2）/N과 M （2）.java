import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static List<int[]> list;
	static int[] number;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList<>();
		number = new int[M];

		comb(0, 1);

		System.out.println(sb.toString());
	}

	private static void comb(int cnt, int start) {

		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(number[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i <= N; i++) {
			number[cnt] = i;
			comb(cnt + 1, i + 1);
		}

	}

}