import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			LinkedList<Integer>[] list = new LinkedList[26];
			
			//초기화
			for(int i=0; i<26; i++) {
				list[i] = new LinkedList<>();
			}
			
			String W = br.readLine();
			int K = Integer.parseInt(br.readLine());
			
			for(int i=0; i<W.length(); i++) {
				list[W.charAt(i)-'a'].add(i);
				if(list[W.charAt(i)-'a'].size()==K) {
					min = Math.min(min, i-list[W.charAt(i)-'a'].get(0)+1);
					max = Math.max(max, i-list[W.charAt(i)-'a'].get(0)+1);
					list[W.charAt(i)-'a'].remove(0);
				}
			}
			if(min==Integer.MAX_VALUE || max == Integer.MIN_VALUE) {
				System.out.println(-1);
			}
			else {
				System.out.println(min + " " + max);
			}
		}
	}

}
