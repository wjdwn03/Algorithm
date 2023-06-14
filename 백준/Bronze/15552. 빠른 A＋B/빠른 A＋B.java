import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        int T = Integer.parseInt(br.readLine());
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
		StringBuilder sb = new StringBuilder();
        
		int a=0, b=0;
		
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			sb.append(a+b);
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}