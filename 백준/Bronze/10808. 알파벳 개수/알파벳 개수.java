import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String S = br.readLine();

		int[] arr = new int[26];

		int len = S.length();

		for (int i = 0; i < len; i++) {
			arr[S.charAt(i) - 'a']++;
		}

		for (int i = 0; i < 26; i++) {
			sb.append(arr[i]).append(" ");
		}

		System.out.println(sb.toString());
	}

}