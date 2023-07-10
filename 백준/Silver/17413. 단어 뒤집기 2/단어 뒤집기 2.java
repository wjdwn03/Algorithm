import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String S = br.readLine();

		Deque<Character> deque = new ArrayDeque<>();

		for (int s = 0; s < S.length(); s++) {

			// '<'가 나온 경우
			if (S.charAt(s) == '<') {

				// deque가 비어 있지 않은 경우
				if (!deque.isEmpty()) {
					// 바로 이전까지가 단어였을 것이므로 뒤에서부터 출력
					while (!deque.isEmpty()) {
						sb.append(deque.pollLast());
					}
				}
				// 뒤로 insert
				deque.offer(S.charAt(s));
			}

			// '>'가 나온 경우
			else if (S.charAt(s) == '>') {

				// 비어 있지 않은 경우
				while (!deque.isEmpty()) {
					// 단어가 아니므로 앞에서부터 출력
					sb.append(deque.pop());
				}
				sb.append(">");
			}

			// 공백일 경우
			else if (S.charAt(s) == ' ') {
				// 맨 앞이 '<' 라면 < > 사이에 있는 공백이다. 그래서 그냥 deque에 넣어준다.
				if (deque.peekFirst().equals('<')) {
					deque.offer(S.charAt(s));
				}

				// 맨 앞이 '<'가 아니면 단어 구분자이기 때문에 단어를 거꾸로 출력한다.
				else {
					while (!deque.isEmpty()) {
						sb.append(deque.pollLast()); // 뒤에서부터 꺼내기
					}
					sb.append(" ");
				}
			}

			// 알파벳 소문자, 숫자가 나온 경우는 그냥 넣어준다.
			else {
				deque.offer(S.charAt(s)); // 뒤로 insert
			}
		} // end for s

		// 끝 음절이 단어인 경우 deque에 아직 남아 있을 것이다.
		if (!deque.isEmpty()) {
			while (!deque.isEmpty()) {
				sb.append(deque.pollLast());
			}
		}

		System.out.println(sb.toString());
	} // end main

}