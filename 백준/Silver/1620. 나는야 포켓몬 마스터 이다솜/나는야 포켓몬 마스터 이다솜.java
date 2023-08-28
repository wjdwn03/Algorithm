import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static String[] arr;
	static HashMap<String, Integer> hashmap;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new String[N + 1]; // 각 인덱스에 해당하는 포켓몬 이름 저장
		hashmap = new HashMap<>(); // 포켓몬 이름에 해당하는 인덱스 저장

		for (int i = 1; i <= N; i++) {
			arr[i] = br.readLine();
			hashmap.put(arr[i], i);
		}

		for (int i = 0; i < M; i++) {

			String now = br.readLine();

			// now가 문자인 경우
			if (now.charAt(0) - '0' > 9) {
				sb.append(hashmap.get(now)).append("\n");
			}
			// now가 숫자인 경우
			else {
				int idx = Integer.parseInt(now);
				sb.append(arr[idx]).append("\n");
			}
		} // end for i

		System.out.println(sb.toString());
	}

}