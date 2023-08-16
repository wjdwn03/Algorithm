import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		Egg[] arr = new Egg[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			arr[i] = new Egg(s, w);
		} // end input

		ans = 0;
		int cnt = 0;

		if (N != 1) {
			dfs(0, arr, cnt);
		}

		System.out.println(ans);

	}

	private static void dfs(int now, Egg[] arr, int cnt) {

		if (now == N) {

			ans = Math.max(ans, cnt);
			return;
            
		} // end if

		for (int i = 0; i < N; i++) {

			if (now == i)
				continue;

			int originOne = arr[now].s;
			int originTwo = arr[i].s;

			int eggOne = originOne;
			int eggTwo = originTwo;

			if (arr[now].s > 0 && arr[i].s > 0) {

				eggOne = arr[now].s - arr[i].w;
				eggTwo = arr[i].s - arr[now].w;

			}

			arr[now].s = eggOne;
			arr[i].s = eggTwo;

			if (originOne > 0 && eggOne <= 0)
				cnt++;

			if (originTwo > 0 && eggTwo <= 0)
				cnt++;

			dfs(now + 1, arr, cnt);

			arr[now].s = originOne;
			arr[i].s = originTwo;

			if (originOne > 0 && eggOne <= 0)
				cnt--;
			if (originTwo > 0 && eggTwo <= 0)
				cnt--;

		}
	}

	static class Egg {
		int s, w;

		public Egg(int s, int w) {
			this.s = s;
			this.w = w;
		}
	}

}