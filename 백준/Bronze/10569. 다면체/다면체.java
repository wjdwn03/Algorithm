import java.io.*;
import java.util.*;

public class Main {

	static int T, V, E;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
            
            st = new StringTokenizer(br.readLine());
            
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            
			sb.append(2-V+E).append("\n");
		}

		System.out.println(sb.toString());
	}

	

}