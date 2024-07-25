import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		int ans = 0;

		for (int i = 5; i > 0; i--) {
			ans += t / i;
			t %= i;
		}

		System.out.println(ans);
	}

}