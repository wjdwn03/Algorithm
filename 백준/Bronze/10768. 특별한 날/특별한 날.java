import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int m = Integer.parseInt(br.readLine());
		int d = Integer.parseInt(br.readLine());

		if (m > 2) {
			System.out.println("After");
		} else if (m == 2) {
			if (d > 18) {
				System.out.println("After");
			} else if (d < 18) {
				System.out.println("Before");
			} else
				System.out.println("Special");
		} else {
			System.out.println("Before");
		}
	}

}