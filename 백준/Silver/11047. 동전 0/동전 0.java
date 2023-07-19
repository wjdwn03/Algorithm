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
		int[] coins = new int[N];
		int cnt = 0; // 정답
		int maxIdx = -1; // K보다 작은 동전의 가치 중 가장 큰 동전의 index
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			// 크다면 더 이상 볼 필요 없다.
			if(num>K) {
				maxIdx = i-1;
				break;
			}
			// 같은 경우 그 동전 한 개만 쓰면 된다.
			if(num==K) {
				cnt = 1;
				break;
			}
			
			coins[i] = num;
			
		} // end input
		
		
		if(cnt!=1) {
			
			// "가장 큰 동전의 가치 < K" 인 경우 N-1 위치부터 계산해봐야 한다.
			if(maxIdx==-1) {
				maxIdx=N-1;
			}
			
			for(int i = maxIdx; i>=0; i--) {
				
				cnt += K/coins[i];
				K %= coins[i];
				
				if(K==0) {
					break;
				}
			}
		} 
		
		System.out.println(cnt);
	}

}