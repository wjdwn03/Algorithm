import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int sec = 0;

		for (int i = 0; i < 4; i++) {
			sec += Integer.parseInt(br.readLine());
		}

		sb.append(sec / 60).append("\n").append(sec % 60);

		System.out.println(sb.toString());
	}

}