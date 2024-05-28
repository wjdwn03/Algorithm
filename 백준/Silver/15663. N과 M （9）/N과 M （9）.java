import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	static int N, M;
	static int[] input;
	static int[] numbers;
	static boolean[] isSelected;
	static Set<String> set;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		input = new int[N];
		isSelected = new boolean[N];
		numbers = new int[M];
		set = new TreeSet<>();

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input);
		perm(0);

		System.out.println(sb.toString());

	}

	private static void perm(int cnt) {

		if (cnt == M) {
			StringBuilder ans = new StringBuilder();

			for (int i = 0; i < M; i++) {
				ans.append(numbers[i]).append(" ");
			}

			if (!set.contains(ans.toString())) {
				sb.append(ans).append("\n");
				set.add(ans.toString());
			}
			return;
		}

		for (int i = 0; i < N; i++) { // 선택지
			// 시도하는 수가 선택되었는지 판단
			if (isSelected[i])
				continue;
			// 앞쪽에서 선택되지 않았다면 수를 사용
			numbers[cnt] = input[i];
			isSelected[i] = true;
			// 다음수 뽑으러 가기
			perm(cnt + 1);
			// 사용했던 수에 대한 선택 되돌리기
			isSelected[i] = false;
		}

	}

}