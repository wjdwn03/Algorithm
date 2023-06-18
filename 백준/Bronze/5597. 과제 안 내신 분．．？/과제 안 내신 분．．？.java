import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] check = new boolean[31];
		StringBuilder sb = new StringBuilder();
		
		int idx=0;
		
		for(int i=0; i<28; i++) {
			idx = Integer.parseInt(br.readLine());
			
			check[idx] = true;
		}
		
		for(int i=1; i<31; i++) {
			if(!check[i]) {
				sb.append(i).append("\n");
			}
		}
		System.out.print(sb.toString());
	}

}