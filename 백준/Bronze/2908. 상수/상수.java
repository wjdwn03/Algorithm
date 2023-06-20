import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		
		int sA = ((A%10)*100) + ((A/10*10)%100) + (A/100);
		int sB = ((B%10)*100) + ((B/10*10)%100) + (B/100);
		
		int max = Math.max(sA, sB);
		
		System.out.println(max);
	}

}