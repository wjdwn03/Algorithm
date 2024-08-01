import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		String[] input = new String[N];
		
		for(int i=0; i<N; i++) {
			input[i] = br.readLine();
		}
		
		int size = input[0].length();
		
		for(int j=0; j<size; j++) {
			
			boolean check = true;
			char before = input[0].charAt(j);
			
			for(int i=1; i<N; i++) {
				
				if(before != input[i].charAt(j)) {
					check = false;
					break;
				}
				
				before = input[i].charAt(j);
			}
			
			if(check) {
				sb.append(input[0].charAt(j));
			}
			else {
				sb.append("?");
			}
		}
		
		System.out.println(sb);
	}

}