import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		char input = br.readLine().charAt(0);

		if (input == 'N' || input == 'n') {
			sb.append("Naver D2");
		} else {
			sb.append("Naver Whale");
		}

		System.out.println(sb.toString());
	}

}