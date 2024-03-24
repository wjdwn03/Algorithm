import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();

		Set<Character> set = new HashSet<>();

		for (int i = 0; i < input.length(); i++) {
			set.add(input.charAt(i));
		}

		String mobis = "MOBIS";

		boolean check = true;

		for (int i = 0; i < 5; i++) {
			if (!set.contains(mobis.charAt(i))) {
				check = false;
				break;
			}
		}

		if (check)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

}