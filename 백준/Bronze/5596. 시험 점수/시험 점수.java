import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int min = 0, man = 0;

		for (int i = 0; i < 4; i++) {
			min += Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < 4; i++) {
			man += Integer.parseInt(st.nextToken());
		}

		System.out.println(Math.max(min, man));
	}

}