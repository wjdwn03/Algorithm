import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		int quarter = 25;
		int dime = 10;
		int nickel = 5;

		for (int t = 0; t < T; t++) {
			int C = Integer.parseInt(br.readLine());

			sb.append(C / quarter).append(" ");

			C %= quarter;

			sb.append(C / dime).append(" ");

			C %= dime;

			sb.append(C / nickel).append(" ");

			C %= nickel;

			sb.append(C).append("\n");
		}

		System.out.println(sb.toString());
	}

}
