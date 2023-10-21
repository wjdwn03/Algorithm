import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[2001];

		st = new StringTokenizer(br.readLine());

		int num = 0;

		for (int i = 0; i < N; i++) {
			num = Integer.parseInt(st.nextToken()) + 1000;

			if (arr[num] == 1)
				continue;

			arr[num] = 1;
		}

		for (int i = 0; i < 2001; i++) {
			if (arr[i] == 1) {
				sb.append(i - 1000).append(" ");
			}
		}
		System.out.println(sb.toString());
	}

}