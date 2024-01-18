import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int money = 1000 - Integer.parseInt(br.readLine());

		// 500원
		int cnt = money / 500;
		money %= 500;

		// 100원
		cnt += money / 100;
		money %= 100;

		// 50원
		cnt += money / 50;
		money %= 50;

		// 10원
		cnt += money / 10;
		money %= 10;

		// 5원
		cnt += money / 5;
		money %= 5;

		// 1원
		cnt += money;

		System.out.println(cnt);
	}

}