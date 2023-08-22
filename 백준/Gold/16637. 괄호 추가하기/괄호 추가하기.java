import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static int N, ans;
	static List<Character> operator;
	static List<Integer> num;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		operator = new ArrayList<>();
		num = new ArrayList<>();

		ans = Integer.MIN_VALUE;

		N = Integer.parseInt(br.readLine());

		String input = br.readLine();

		if (N != 1) {
			for (int i = 0; i < N; i++) {
				if (i % 2 == 0) {
					num.add(input.charAt(i) - '0');
				} else {
					operator.add(input.charAt(i));
				}
			}

			int sum = input.charAt(0) - '0';

			dfs(sum, 0);
		} else {
			ans = Integer.parseInt(input);
		}

		System.out.println(ans);
	}

	private static void dfs(int sum, int idx) {

		if (idx >= operator.size()) {
			ans = Math.max(ans, sum);
			return;
		}

		// 괄호없이
		int tmp = calculate(sum, num.get(idx + 1), idx);
		dfs(tmp, idx + 1);

		// 괄호 추가
		if (idx + 1 < operator.size()) {
			tmp = calculate(num.get(idx + 1), num.get(idx + 2), idx + 1);
			int tmpTwo = calculate(sum, tmp, idx);
			dfs(tmpTwo, idx + 2);
		}

	}

	private static int calculate(int a, int b, int operatorIdx) {
		if (operator.get(operatorIdx) == '+') {
			return a + b;
		} else if (operator.get(operatorIdx) == '-') {
			return a - b;
		} else {
			return a * b;
		}
	}

}