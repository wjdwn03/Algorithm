import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		
		for(int n = 0; n<N; n++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		// 내림차순 정렬
		Collections.sort(list, Collections.reverseOrder());
		
		
		int max = list.get(0); // 정답
		int min = list.get(0); // n개의 로프 중 최소 중량 저장
		
		for(int n=0; n<N; n++) {
			
			min = Math.min(min, list.get(n));
			
			if(max > min * (n+1)) // (최소 중량 * n) 이 max의 값보다 작거나 같으면 넘긴다.
				continue;
			
			// max의 중량을 n개의 로프에 동일한 중량으로 나눠서 걸려면 (n개의 로프 중 최소 중량 * n)을 해야 최댓값이 나옴.
			max = min * (n+1); 
		}
		
		System.out.println(max);
		
	}

}