import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] road = new int[N - 1]; // 도로 길이 저장
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 도로 길이 입력
		for (int i = 0; i < N - 1; i++) {
			road[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		
		// 리터당 최소 가격
		int min = Integer.MAX_VALUE;
		// 정답
		int ans = 0; 
		
		// 제일 마지막에 있는 도시의 가격은 필요 없기 때문에 N-2까지만 본다.
		for (int i = 0; i < N - 1; i++) {
			
			
			int gas = Integer.parseInt(st.nextToken());
			
			if (gas < min) {
				min = gas;
			}

			ans += road[i] * min; // 모든 도시에 갈 때마다 최소 가격으로만 구매
		}
		
		System.out.println(ans);
	}

}