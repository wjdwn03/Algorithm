import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] document = br.readLine().toCharArray();

		char[] word = br.readLine().toCharArray();

		int start = 0;
		int end = word.length - 1;
		int ans = 0;

		int documentLen = document.length;
		int wordLen = word.length;

		while (end < documentLen) {

			int idx = 0;
			boolean check = true;

			for (int i = start; i <= end; i++) {
				if (document[i] != word[idx]) {
					check = false;
					break;
				}
				idx++;
			}

			if (check) {
				ans++;
				start = end + 1;
				end += wordLen;
			} else {
				start++;
				end++;
			}

		}
		System.out.println(ans);

	}

}