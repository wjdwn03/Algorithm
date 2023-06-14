import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		int end = N/4;
		
		for(int i=0; i<end; i++) {
			sb.append("long").append(" ");
		}
		sb.append("int");
		System.out.println(sb.toString());
	}

}