import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int won = Integer.parseInt(br.readLine());

		int se = Integer.parseInt(br.readLine());

		int sang = Integer.parseInt(br.readLine());

		int sung = Integer.parseInt(br.readLine());

		int gang = Integer.parseInt(br.readLine());

		won = won < 40 ? 40 : won;
		se = se < 40 ? 40 : se;
		sang = sang < 40 ? 40 : sang;
		sung = sung < 40 ? 40 : sung;
		gang = gang < 40 ? 40 : gang;

		System.out.println((won + se + sang + sung + gang) / 5);

	}

}