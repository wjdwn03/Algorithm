import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		int idx = N - 1;
		int price = 0; // 정답은 int의 최대값인 2^31 - 1보다 작거나 같기 때문에 int 써도 된다. 아마도?

		while (idx - 2 >= 0) {

			price += arr[idx] + arr[idx - 1]; // 가장 저렴한 것은 무료이므로 더하지 않는다.
			idx -= 3;
		}

		// 2+1로 묶이지 않고 남은 유제품이 있는 경우
		if (N % 3 == 1) {
			price += arr[idx];
		} else if (N % 3 == 2) {
			price += arr[idx] + arr[idx - 1];
		}

		System.out.println(price);
	}

}