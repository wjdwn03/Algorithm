import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int budget = Integer.parseInt(br.readLine());

		int junCash = budget, sungCash = budget, junStock = 0, sungStock = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());
		int before = Integer.parseInt(st.nextToken());
		int now = before, up = 0, down = 0;

		for (int i = 1; i < 14; i++) {
			
			// 준현이
			if (junCash >= now) {
				junStock = junCash / now;
				junCash -= (junStock * now);
			}

			// 성민이
			if (now > before) {
				up++;
				down = 0;

				// 주식이 계속 올라갈 경우
				if (up >= 3 && sungStock > 0) {
					sungCash += sungStock * now;
					sungStock = 0;
				}
			} else if (now < before) {
				down++;
				up = 0;

				// 주식이 계속 내려갈 경우
				if (down >= 3 && sungCash >= now) {
					sungStock = sungCash / now;
					sungCash -= sungStock * now;
				}
			}

			before = now; // before 값 갱신

			// 토큰을 일단 하나 먼저 인풋하고 for로 들어오기 때문에 제일 마지막에 갱신해줘야 한다.
			now = Integer.parseInt(st.nextToken());

		} // end input

		junCash += now * junStock;
		sungCash += now * sungStock;
		
		if (junCash > sungCash) {
			System.out.println("BNP");
		} else if (junCash < sungCash) {
			System.out.println("TIMING");
		} else {
			System.out.println("SAMESAME");
		}

	}

}