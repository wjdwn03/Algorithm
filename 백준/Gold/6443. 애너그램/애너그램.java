import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeSet;

public class Main {

	static int N, R;
	static String input;
	static Deque<Character> stack;
	static int[] check;
	static StringBuilder sb;
	static TreeSet<String> set;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			input = br.readLine();
			R = input.length();
			check = new int[26];
			set = new TreeSet<>();
			stack = new ArrayDeque<>();

			for (int j = 0; j < R; j++) {
				check[input.charAt(j) - 'a']++;
			}

			perm(R);

			String[] ans = set.toArray(new String[set.size()]);

			for (String tmp : ans) {
				sb.append(tmp).append("\n");
			}
		}

		System.out.println(sb.toString());
	}

	private static void perm(int cnt) {

		if (cnt == stack.size()) {
			String str = "";
			for (char c : stack) {
				str += c;
			}
			if (!set.contains(str))
				set.add(str);
			return;
		}

		for (int i = 0; i < 26; i++) {
			if (check[i] <= 0)
				continue;

			check[i]--;
			stack.push((char) (i + 'a'));

			perm(cnt);
			stack.pop();
			check[i]++;

		}
	}

}