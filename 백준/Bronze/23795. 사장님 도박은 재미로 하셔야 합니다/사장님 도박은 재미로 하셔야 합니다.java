import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int money = Integer.parseInt(br.readLine());
		int sum = 0;

		while (money != -1) {
			sum += money;
			money = Integer.parseInt(br.readLine());
		}

		System.out.println(sum);
	}

}