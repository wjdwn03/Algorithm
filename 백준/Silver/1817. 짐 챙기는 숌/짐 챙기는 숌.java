import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		
		if(n!=0) {
			st = new StringTokenizer(br.readLine());
			
			int sum = 0;
			
			for(int i=0; i<n; i++) {
				int num = Integer.parseInt(st.nextToken());
				
				sum+=num;

				if(sum>=m) {
					
					if(sum==m) {
						sum = 0;
					}
					else {
						sum = num;
					}
					cnt++;
					
				}
			} // end for i
			
			if(sum != 0) {
				cnt++;
			}
			
		} // end if
		
		System.out.println(cnt);
	}

}