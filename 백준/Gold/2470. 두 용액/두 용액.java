import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, ans;
	static int[] water;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		water = new int[2]; // 두 용액을 저장할 배열
		arr = new int[N];
		int negativeCnt = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i] < 0) {
				negativeCnt++;
			}
		} // tail input

		Arrays.sort(arr);

		// 전부 음수인 경우
		if (negativeCnt == N) {
			water[0] = arr[N - 2];
			water[1] = arr[N - 1];
		}
		// 전부 양수인 경우
		else if (negativeCnt == 0) {
			water[0] = arr[0];
			water[1] = arr[1];
		}
		// 음수, 양수 혼합
		else {

			ans = 2_000_000_000;
			water[0] = arr[0];
			water[1] = arr[N - 1];

			if (N > 2) {
				int head = 0;
				int tail = N - 1;

				while (head <= tail) {
					if (arr[head] + arr[tail] == 0) {
						water[0] = arr[head];
						water[1] = arr[tail];
						break;
					}
					if (arr[head] + arr[tail] > 0) {
						if (arr[head] + arr[tail] < ans) {
							ans = arr[head] + arr[tail];
							water[0] = arr[head];
							water[1] = arr[tail];
						}
						tail--;
					} else if (arr[head] + arr[tail] < 0) {
						if (Math.abs(arr[head] + arr[tail]) < ans) {
							ans = Math.abs(arr[head] + arr[tail]);
							water[0] = arr[head];
							water[1] = arr[tail];
						}
						head++;
					}
					if (head == tail) {
						tail--;
					}
				} // end while

			} // end if
		}

		System.out.println(water[0] + " " + water[1]);
	}

}