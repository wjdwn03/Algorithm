import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String input = br.readLine();

		if (input.equals("SONGDO"))
			sb.append("HIGHSCHOOL");
		else if (input.equals("CODE"))
			sb.append("MASTER");
		else if (input.equals("2023"))
			sb.append("0611");
		else
			sb.append("CONTEST");

		System.out.println(sb.toString());
	}

}