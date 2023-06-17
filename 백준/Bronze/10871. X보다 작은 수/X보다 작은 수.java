import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int num=0;
		for(int i=0; i<N; i++) {
			
			num = Integer.parseInt(st.nextToken());
			if(num<X) {
				sb.append(num).append(" ");
			}
			
		}
		
		System.out.println(sb.toString());
	}

}