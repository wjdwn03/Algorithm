import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine()); // 도로 길이
		StringTokenizer st2 = new StringTokenizer(br.readLine()); // 리터당 가격

		// 리터당 최소 가격
		long min = 1000000001;
		// 정답
		long ans = 0;

		// 제일 마지막에 있는 도시의 가격은 필요 없기 때문에 N-2까지만 본다.
		for (int i = 0; i < N - 1; i++) {

			int gas = Integer.parseInt(st2.nextToken());
			int road = Integer.parseInt(st.nextToken());

			if (gas < min) {
				min = (long) gas;
			}

			ans += road * min; // 모든 도시에 갈 때마다 최소 가격으로만 구매
		}

		System.out.println(ans);
	}

}
