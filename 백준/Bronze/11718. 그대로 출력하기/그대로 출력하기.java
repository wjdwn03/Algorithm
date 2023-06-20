import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			try {
				String word = br.readLine();
				if(word.isEmpty()) {
					break;
				}
				sb.append(word).append("\n");
			}catch(NullPointerException | NoSuchElementException e){
				break;
			}
		}
		System.out.print(sb.toString());
	}

}