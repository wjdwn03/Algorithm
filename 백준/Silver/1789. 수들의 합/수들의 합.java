import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long N = Long.parseLong(br.readLine());
		Set<Long> set = new HashSet<>();

		long num = 1L;

		while (num <= N) {
			N -= num;
			set.add(num++);
		}

		System.out.println(set.size());
	}

}