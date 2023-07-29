import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String word = br.readLine();

		word = word.toUpperCase();

		int[] arr = new int[26];

		for (int i = 0; i < word.length(); i++) {
			arr[word.charAt(i) - 'A']++;
		}

		int max = -1;
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < 26; i++) {
			if (arr[i] == max) {
				list.add(i);
			}
			if (arr[i] > max) {
				max = arr[i];
				list.clear();
				list.add(i);
			}
		}

		if (list.size() > 1) {
			System.out.println("?");
		} else {
			char alpha = (char) (list.get(0) + 'A');
			System.out.println(alpha);
		}

	}

}