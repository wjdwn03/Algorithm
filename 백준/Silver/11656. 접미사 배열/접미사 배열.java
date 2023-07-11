import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String S = br.readLine();
		int size = S.length();
		
		Queue<String> queue = new PriorityQueue<>();
		
		for(int i=0; i<size; i++) {
//			String word = "";
//			for(int j=size-i; j<size; j++) {
//				word+=S.charAt(j);
//			}
			queue.add(S.substring(i));
		}
		
		while(!queue.isEmpty()) {
			sb.append(queue.poll()).append("\n");
		}
		
		System.out.println(sb.toString());
		
	}

}