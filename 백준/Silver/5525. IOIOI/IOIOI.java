import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		char[] arr = br.readLine().toCharArray();

		int ans = 0;
		int oCnt = 0;

		char before = arr[0];
		char now = ' ';

		boolean start = false;

		for (int i = 1; i < M; i++) {

			now = arr[i];

			if (before != now) {

				// OIOI 중 IO 일 때
				if (before == 'I' && !start) {
					start = true;
				}
				// OIOI 중 OI 일 때
				else if (start && before == 'O') {

					if (++oCnt == N) {
						ans++;
						oCnt--;
					}
				}
			} // end if

			else {
				oCnt = 0;
				start = false;
			}

			before = now;
		} // end for i

		System.out.println(ans);
	}

}