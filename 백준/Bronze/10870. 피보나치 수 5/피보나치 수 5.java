import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new int[21];

		arr[1] = 1;

		int ans = fibo(N);
		
		System.out.println(ans);

	}

	private static int fibo(int idx) {

		if (idx < 2)
			return arr[idx];
		// 메모이제이션
		arr[idx] = fibo(idx - 1) + fibo(idx - 2);

		return arr[idx];

	}

}