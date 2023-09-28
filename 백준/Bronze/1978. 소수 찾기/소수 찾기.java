import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		// 0 : 소수, 1 : 소수 아님
		int[] arr = new int[1001];

		arr[1] = 1;
		arr[0] = 1;

		for (int i = 2; i < 1001; i++) {
			for (int j = i; j < 1001; j += i) {
				if (i == j || arr[j] == 1)
					continue;

				arr[j] = 1;
			}
		}

		StringTokenizer st = new StringTokenizer(br.readLine());

		int cnt = 0;

		while (st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());

			if (arr[num] == 0)
				cnt++;
		}

		System.out.println(cnt);
	}

}