import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int[] arr = new int[B];

		int idx = 0;
		int num = 1;
		int cnt = 0;

		while (idx < B) {

			arr[idx++] = num;

			if (++cnt == num) {
				num++;
				cnt = 0;
			}

		}

		int sum = 0;

		for (int i = A - 1; i < B; i++) {
			sum += arr[i];
		}

		System.out.println(sum);
	}

}