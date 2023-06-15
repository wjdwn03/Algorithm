import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
        int a=0, b=0;

		while (true) {
			try {
			    st = new StringTokenizer(br.readLine());
			
			    a = Integer.parseInt(st.nextToken());
			    b = Integer.parseInt(st.nextToken());

			    sb.append(a + b).append("\n");
			} catch(NoSuchElementException e) {
				break;
			} catch(NullPointerException e) {
				break;
			}

		} // end while

		System.out.println(sb.toString());
	}

}