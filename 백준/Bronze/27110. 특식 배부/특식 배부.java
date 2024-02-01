import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[3];
		int ans = 0;

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < 3; i++) {

			arr[i] = Integer.parseInt(st.nextToken());

			if (arr[i] >= N)
				ans += N;
			else
				ans += arr[i];
		}

		System.out.println(ans);
	}

}