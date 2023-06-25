import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String S = br.readLine();
		
		int[] arr = new int[26];
		Arrays.fill(arr, -1);
		
		for(int i=0; i<S.length(); i++) {
			if(arr[S.charAt(i)-'a']==-1) {
				arr[S.charAt(i)-'a'] = i;
			}
		}
		
		for(int i=0; i<26; i++) {
			sb.append(arr[i]).append(" ");
		}
		
		System.out.println(sb.toString());
		
	}

}