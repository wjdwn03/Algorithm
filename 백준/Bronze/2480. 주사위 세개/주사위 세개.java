import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		int max = Integer.MIN_VALUE;
		int reward = 0;
		
		max = Math.max(max, a);
		max = Math.max(max, b);
		max = Math.max(max, c);
		
		if(a==b) {
			cnt++;
			reward = 1000+a*100;
			if(a==c) {
				cnt++;
				reward = 10000+a*1000;
			}
			
		}
		else if(b==c) {
			cnt++;
			reward = 1000+b*100;
			if(a==c) {
				cnt++;
				reward = 10000+a*1000;
			}
		}
		else if(a==c) {
			cnt++;
			reward = 1000+a*100;
			if(b==c) {
				cnt++;
				reward = 10000+a*1000;
			}
		}
		
		
		if(cnt==0) {
			reward = max * 100;
		}
		
		System.out.println(reward);
		
	}

}