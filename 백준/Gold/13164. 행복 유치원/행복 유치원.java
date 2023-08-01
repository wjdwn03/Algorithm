import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int sum = 0;

		if (N != K) {

			int[] arr = new int[N];
			int[] gap = new int[N - 1];

			st = new StringTokenizer(br.readLine());

			arr[0] = Integer.parseInt(st.nextToken());

			for (int i = 1; i < N; i++) {
				int tall = Integer.parseInt(st.nextToken());

				arr[i] = tall;

				gap[i - 1] = arr[i] - arr[i - 1]; // 키 차이 저장
				sum += gap[i - 1]; // 키 차이 전부 덧셈
			}

			// 오름차순 정렬
			Arrays.sort(gap);

			// 제일 큰 수부터 K개의 키차이 빼주기
			for (int i = N - 2; i >= N - K; i--) {
				sum -= gap[i];
			}

		} // end if

		System.out.println(sum);
	}

}