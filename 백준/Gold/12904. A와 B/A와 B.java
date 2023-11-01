import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static char[] S, T;
	static int ans, tLen;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		S = br.readLine().toCharArray();
		T = br.readLine().toCharArray();

		ans = 0; // 정답
		tLen = T.length; // T의 길이
		int sLen = S.length;
		int start = 0;
		int end = tLen - 1;
		int dir = 1; // 방향(1: 정방향, -1 : 역방향)

		while (start <= end) {

			// T가 S의 길이가 되면
			if (end - start == sLen - 1) {
				int idx = 0; // T 탐색할 인덱스
				boolean check = true; // A와 같은지 확인할 변수

				// 정방향이면 start부터 확인
				if (dir == 1)
					idx = start;
				// 역방향이면 end부터 확인
				else
					idx = end;

				for (int i = 0; i < sLen; i++) {
					if (S[i] != T[idx]) {
						check = false;
						break;
					}
					idx += dir;
				}

				if (check) {
					ans = 1;
					break;
				}
			}

			// 정방향
			if (dir == 1) {

				// 끝이 B면 방향을 바꿔줌.
				if (T[end] == 'B') {
					dir *= -1;
				}
				end--;
			}
			// 역방향
			else {
				if (T[start] == 'B') {
					dir *= -1;
				}
				start++;
			}
		}
		System.out.println(ans);
	}
}