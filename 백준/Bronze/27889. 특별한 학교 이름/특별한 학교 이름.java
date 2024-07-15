import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String input = br.readLine();

		if (input.equals("NLCS")) {
			sb.append("North London Collegiate School");
		} else if (input.equals("BHA")) {
			sb.append("Branksome Hall Asia");
		} else if (input.equals("KIS")) {
			sb.append("Korea International School");
		} else {
			sb.append("St. Johnsbury Academy");
		}

		System.out.println(sb.toString());
	}

}