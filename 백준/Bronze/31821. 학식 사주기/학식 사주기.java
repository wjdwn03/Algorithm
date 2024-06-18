import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] menu = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			menu[i] = Integer.parseInt(br.readLine());
		}
		
		int M = Integer.parseInt(br.readLine());
		int sum = 0;
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(br.readLine());
			
			sum += menu[num];
		}
		
		System.out.println(sum);
	}

}