import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int ans = Math.abs(A - B);

		int N = Integer.parseInt(br.readLine());
		int f = 0; // 지정 주파수
		int tmp = 0;

		for (int i = 0; i < N; i++) {
			f = Integer.parseInt(br.readLine());

			tmp = Math.abs(f - B) + 1;

			ans = Math.min(tmp, ans);

		}

		System.out.println(ans);

	}

}