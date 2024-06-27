import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		int N = Integer.parseInt(br.readLine());

		String[] arr = new String[N];
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();

			arr[i] = tmp + tmp;

			if (arr[i].contains(input)) {
				cnt++;
			}
		} // end input

		System.out.println(cnt);
	}

}