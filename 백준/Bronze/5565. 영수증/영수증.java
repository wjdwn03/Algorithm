import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int ten = Integer.parseInt(br.readLine());

		int nine = 0;

		for (int i = 0; i < 9; i++) {
			nine += Integer.parseInt(br.readLine());
		}

		System.out.println(ten - nine);
	}

}