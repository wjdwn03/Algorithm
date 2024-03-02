import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int num = 2;
		int cnt = 1;

		if (N > 1) {

			while (num <= N) {
				num += cnt * 6;
				cnt++;
			}
		}

		System.out.println(cnt);
	}

}