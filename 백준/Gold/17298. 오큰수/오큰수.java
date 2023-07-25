import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		Deque<Integer> temp = new ArrayDeque<>();
		Deque<Integer> nge = new ArrayDeque<>(); // 오큰수 저장할 스택

		// 수열 입력
		for (int i = 0; i < N; i++) {

			int num = Integer.parseInt(st.nextToken());

			arr[i] = num;

		} // end input

		int before = arr[N - 1]; // 오른쪽 끝에서부터 볼 것이다.

		nge.push(-1); // 오른쪽 끝은 오큰수가 없기 때문에 일단 -1을 넣는다.
		temp.push(before);

		for (int i = N - 2; i >= 0; i--) {

			// temp 스택에 현재 값보다 작거나 같으면 큰 값이 나올 때까지 pop 한다.
			while (!temp.isEmpty() && temp.peek() <= arr[i]) {
				temp.pop();
			}
			// 모두 pop 한 경우 temp가 비어있을 것이고, 그렇다는건 현재 값보다 큰 값은 없다는 말이다.
			if (temp.isEmpty()) {
				nge.push(-1);
			}
			// !temp.isEmpty()인 경우 arr[i]보다 큰 값이 temp에 남아 있다는 말이다.
			else {
				nge.push(temp.peek());
			}

			temp.push(arr[i]);

		}

		while (!nge.isEmpty()) {
			sb.append(nge.pop()).append(" ");
		}

		System.out.println(sb.toString());

	}

}