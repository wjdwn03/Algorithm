import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int ans = 0; // 정답

		while (true) {
			int tmp = N; // 현재 가지고 있는 물병의 수
			int cnt = 0; // 추가로 구매할 물병의 수

			while (tmp > 0) {
				// 홀수일 때 물병을 하나 구매
				if (tmp % 2 == 1)
					cnt++;
				tmp /= 2;
			}

			if (cnt <= K)
				break;

			ans++;
			N++;
		}

		System.out.println(ans);
	}

}