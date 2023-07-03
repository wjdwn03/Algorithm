import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		
		for(int t=0; t<T; t++) {
			String word = br.readLine();
			
			sb.append(word.charAt(0)).append(word.charAt(word.length()-1)).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}