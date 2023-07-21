import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		long[] arr = new long[N]; // 근손실 정도의 최댓값이 10^18 이므로 long으로 함.

		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(arr);

		int endIdx = N - 1;
		long m = Long.MIN_VALUE; // 정답

		// 홀수면 N-1 자리의 근손실은 굳이 계산하지 않아도 된다.
		if (N % 2 == 1) {
			endIdx = N - 2;
			m = arr[N - 1];
		}

		// 배열 맨 앞과 맨 뒤를 더할 것이기 때문에 for문을 절반만 돌면 된다.
		int endFor = endIdx / 2;

		for (int i = 0; i <= endFor; i++) {

			long mLoss = arr[i] + arr[endIdx - i];

			if (mLoss > m) {
				m = mLoss;
			}

		}

		System.out.println(m);
	}

}