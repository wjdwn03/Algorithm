import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] sience = new int[4];
		int[] society = new int[2];

		for (int i = 0; i < 4; i++) {
			sience[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < 2; i++) {
			society[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(sience);
		Arrays.sort(society);

		System.out.println(sience[1] + sience[2] + sience[3] + society[1]);
	}

}