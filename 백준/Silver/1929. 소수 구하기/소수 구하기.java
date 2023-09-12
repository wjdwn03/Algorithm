import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[] arr = new int[M + 1]; // 0 : 소수 O , 1 : 소수 X

		arr[0] = 1;
		arr[1] = 1;

		for (int i = 2; i <= M; i++) {

			// 소수가 아닌 경우
			if (arr[i] == 1)
				continue;

			for (int j = i * 2; j <= M; j += i) {
				arr[j] = 1;
			}
		}

		for (int i = N; i <= M; i++) {
			if (arr[i] == 1)
				continue;
			sb.append(i).append("\n");
		}
		System.out.println(sb.toString());

	}

}