import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int S, P, ans;
	static char[] DNA;
	static int[] ACGT;
	static int[] count;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		ans = 0;

		String dna = br.readLine();

		DNA = dna.toCharArray();

		count = new int[4];
		ACGT = new int[4];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i <= 3; i++) {
			ACGT[i] = Integer.parseInt(st.nextToken());
		} // end input

		for (int i = 0; i < P; i++) {
			switch (DNA[i]) {
			case 'A':
				count[0]++;
				break;
			case 'C':
				count[1]++;
				break;
			case 'G':
				count[2]++;
				break;
			case 'T':
				count[3]++;
				break;
			}
		}

		if (check()) {
			ans++;
		}
		for (int i = 1; i <= S - P; i++) {
			cal(i - 1, -1);
			cal(P - 1 + i, 1);
			if (check()) {
				ans++;
			}
		}

		System.out.println(ans);
	}

	private static void cal(int i, int sum) {

		switch (DNA[i]) {
		case 'A':
			count[0] += sum;
			break;
		case 'C':
			count[1] += sum;
			break;
		case 'G':
			count[2] += sum;
			break;
		case 'T':
			count[3] += sum;
			break;
		}

	}

	private static boolean check() {

		for (int i = 0; i < 4; i++) {
			if (count[i] < ACGT[i]) {
				return false;
			}
		}
		return true;
	}

}
