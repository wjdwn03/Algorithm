import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		int[][] arr = new int[a.length() + 1][b.length() + 1];
		int ans = 0;

		for (int i = 0; i < a.length(); i++) {
			for (int j = 0; j < b.length(); j++) {
				if (a.charAt(i) == b.charAt(j)) {
					arr[i + 1][j + 1] = arr[i][j] + 1;
					ans = Math.max(ans, arr[i + 1][j + 1]);
				}
			}
		}

		System.out.println(ans);

	}
}