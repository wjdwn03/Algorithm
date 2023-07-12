import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 피연산자 개수
		
		double[] num = new double[N]; // 피연산자에 대응하는 수 저장할 배열

		String postfix = br.readLine(); // 후위 표기식

		// 피연산자에 대응하는 수 저장
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}

		Deque<Double> stack = new ArrayDeque<>();

		for (int i = 0; i < postfix.length(); i++) {

			double a = 0, b = 0;

			// 피연산자인 경우 스택에 추가
			if (postfix.charAt(i) >= 'A' && postfix.charAt(i) <= 'Z') {

				stack.push(num[postfix.charAt(i) - 'A']);

			} 
			// 연산자인 경우 두 수를 스택에서 뽑는다.
			else {

				b = stack.pop();
				a = stack.pop();

				double result = 0;

				switch (postfix.charAt(i)) {
				case '+':
					result = a + b;
					break;
				case '-':
					result = a - b;
					break;
				case '*':
					result = a * b;
					break;
				case '/':
					result = a / b;
					break;
				}

				// 연산자에 맞게 계산 후 다시 스택에 넣어줌.
				stack.push(result);
			}

		}

		System.out.printf("%.2f", stack.poll());

	}

}