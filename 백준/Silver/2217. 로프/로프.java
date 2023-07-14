import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		for(int n = 0; n<N; n++) {
			arr[n] = Integer.parseInt(br.readLine());
		}
		
		// 오름차순 정렬
		Arrays.sort(arr);
		
		int max = arr[N-1]; // 정답
		
		for(int n=N-1; n>=0; n--) {
			
			int w = arr[n] * (N-n);
			
			if(max >= w) // (최소 중량 * n) 이 max의 값보다 작거나 같으면 넘긴다.
				continue;
			
			max = w; 
		}
		
		System.out.println(max);
		
	}

}