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

		while (Integer.bitCount(N) > K) {

			// 1씩 증가시키지 않고
			// 비트 중 가장 우측에 있는 1만큼 더함.
			ans += N & (-N);
			N += N & (-N);
		}

		System.out.println(ans);
	}

}