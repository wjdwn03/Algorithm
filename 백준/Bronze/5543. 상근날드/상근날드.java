import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int bugerH = Integer.parseInt(br.readLine());
		int bugerM = Integer.parseInt(br.readLine());
		int bugerL = Integer.parseInt(br.readLine());

		int coke = Integer.parseInt(br.readLine());
		int cider = Integer.parseInt(br.readLine());

		int minBuger = Math.min(Math.min(bugerH, bugerM), bugerL);
		int minSoda = Math.min(coke, cider);

		System.out.println(minBuger + minSoda - 50);
	}

}