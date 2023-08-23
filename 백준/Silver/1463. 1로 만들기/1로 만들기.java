import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N, ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		ans = 1000001;

		dfs(N, 0);

		System.out.println(ans);

	}

	private static void dfs(int now, int cnt) {

		if (now <= 0 || cnt >= ans)
			return;

		if (now == 1) {
			ans = Math.min(ans, cnt);
			return;
		}

		dfs(now / 3, cnt + 1 + now % 3);
		dfs(now / 2, cnt + 1 + now % 2);

	}

}