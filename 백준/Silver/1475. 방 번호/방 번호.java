import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();

		int[] arr = new int[10];

		int size = num.length();

		for (int i = 0; i < size; i++) {
			int now = num.charAt(i) - '0';
			arr[now]++;
		}

		int ans = 1;

		for (int i = 0; i < 10; i++) {

			if (i == 6 || i == 9)
				continue;

			if (ans < arr[i]) {
				ans += arr[i] - ans;
			}
		}

		int tmp = arr[6] + arr[9];
		int tmpNum = (tmp / 2) + (tmp % 2);

		if (tmpNum > ans) {

			ans += tmpNum - ans;

		}

		System.out.println(ans);

	}

}