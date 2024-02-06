import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M, B, time, hight;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		arr = new int[N * M];
		time = Integer.MAX_VALUE;
		hight = -1;

		int min = Integer.MAX_VALUE;
		int max = -1;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i * M + j] = Integer.parseInt(st.nextToken());

				if (arr[i * M + j] < min)
					min = arr[i * M + j];
				if (arr[i * M + j] > max)
					max = arr[i * M + j];
			}
		} // end input

		// 땅의 최소 높이부터 최대 높이까지를 기준으로 땅 고르기 작업을 시행하여 답을 찾음.
		for (int num = min; num <= max; num++) {
			check(num);
		}

		sb.append(time).append(" ").append(hight);

		System.out.println(sb.toString());

	}

	public static void check(int num) {

		int timeTmp = 0;
		int bTmp = B;

		for (int i = 0; i < N * M; i++) {
			if (arr[i] == num)
				continue;
			// 1번 작업
			else if (arr[i] > num) {
				timeTmp += (arr[i] - num) * 2;
				bTmp += arr[i] - num; // 인벤토리에 넣기
			}
			// 2번 작업
			else {
				timeTmp += num - arr[i];
				bTmp -= num - arr[i]; // 인벤토리에서 꺼내기
			}

			// 최소 시간 초과한 경우 더이상 볼 필요가 없으므로 바로 리턴
			// timeTmp == time 인 경우에는 바로 리턴하며 안됨.
			// 왜냐하면 답이 여러 개 있다면 그중에서 땅의 높이가 가장 높은 것을 출력해야하는 조건 때문
			if (timeTmp > time)
				return;
		}

		// 1번, 2번 작업을 진행하며 인벤토리에 있는 블록으로 평탄화를 할 수 없는 경우 바로 리턴
		if (bTmp < 0)
			return;

		time = Math.min(time, timeTmp);
		hight = Math.max(hight, num);
	}
}