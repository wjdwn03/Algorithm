import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 제일 소요시간이 적은 사람부터 인출해야 최소 시간이 걸린다.
		Arrays.sort(arr);
		
		long sum = 0;
		long time = 0;
		
		for(int i=0; i<N; i++) {
			
			sum += arr[i];
			time += sum;
		}
		
		System.out.println(time);
	}

}