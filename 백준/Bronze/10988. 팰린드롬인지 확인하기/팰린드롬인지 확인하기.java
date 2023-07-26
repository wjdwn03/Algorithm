import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] arr = br.readLine().toCharArray();

		int ans = 1;
		int len = arr.length;

		for (int i = 0; i < len / 2; i++) {

			if (arr[i] != arr[len - i - 1]) {
				ans = 0;
				break;
			}
		}
		
		System.out.println(ans);
	}

}