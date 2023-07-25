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

		int ans = -1;
		int cnt = 1;

		// B에서 A로 만드는게 연산의 최솟값이 나온다.
		while (A != B) {

			// A가 더 커지는 경우 break
			if (A > B) {
				break;
			}
			
			if (B % 2 == 0) {
				B /= 2;
			}
			
			// 홀수인 경우
			else {
				// 끝에 1을 떼어내기 위해 10으로 나눠준다.
				if (B % 10 == 1) {
					B /= 10;
				}
				// 홀수이지만 일의 자리가 1이 아닌 경우 더이상 A를 구할 수 없다.
				else {
					break;
				}
			}

			cnt++;

			if (A == B) {
				ans = cnt;
			}

		} // end while

		System.out.println(ans);
	}

}