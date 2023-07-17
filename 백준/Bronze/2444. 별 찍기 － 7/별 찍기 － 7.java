import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int star = 1;
		
		for(int i = N-1; i>=0; i--) {
			sb = blank(i, sb);
			
			for(int j=1; j<=star; j++) {
				sb.append("*");
			}
			sb.append("\n");
			
			star+=2;
		}
		
		star -=2;
		
		for(int i=1; i<N; i++) {
			sb = blank(i, sb);
			
			star-=2;
			
			for(int j=1; j<=star; j++) {
				sb.append("*");
			}
			sb.append("\n");
			
		}
		
		System.out.println(sb.toString());
	}

	private static StringBuilder blank(int cnt, StringBuilder sb) {
		
		for(int i=0; i<cnt; i++) {
			sb.append(" ");
		}
		
		return sb;
		
	}

}