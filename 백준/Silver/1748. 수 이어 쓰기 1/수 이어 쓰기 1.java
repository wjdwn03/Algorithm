import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		N = Integer.parseInt(input);

		int nLen = input.length();
		int ans = 0;

		for (int i = 0; i < nLen; i++) {
			int num = makeNine(i + 1);

			if (i == nLen - 1) {
				num = N;
			}

			ans += (num - Math.pow(10, i) + 1) * (i + 1);
		}
		
		System.out.println(ans);

	}

	public static int makeNine(int cnt) {

		int idx = 1;
		int result = 9;
		while (idx < cnt) {
			result = result * 10 + 9;
			idx++;
		}
		return result;
	}

}