import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int cnt = 0;
		
		for(int i=0; i<5; i++) {
			int type = Integer.parseInt(st.nextToken());
			if(type == T)
				cnt++;
		}
		
		System.out.println(cnt);
	}

}