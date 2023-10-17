import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] count;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];
		count = new int[3]; // 0 : -1로 채워진 개수, 1: 0으로 채워진 개수, 2 : 1의 개수

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end input

		countPaper(0, 0, N);

		sb.append(count[0]).append("\n").append(count[1]).append("\n").append(count[2]);

		System.out.println(sb.toString());
	}

	private static void countPaper(int nowi, int nowj, int len) {

		int start = arr[nowi][nowj];

		if (len == 1) {
			count[start + 1]++;
			return;
		}

		boolean isAllSame = true; // 모두 같은 숫자로 채워져 있는지 확인용

		// 현재 종이 전체 확인
		for (int i = nowi; i < nowi + len; i++) {
			for (int j = nowj; j < nowj + len; j++) {

				if (start != arr[i][j]) {
					isAllSame = false; // start와 다른 수가 나오는 순간 false로 바꿔서 표시 해줌.
					break;
				}
			} // end for j

			if (!isAllSame) {
				break;
			}

		} // end for i

		// 모두 같은 숫자로 채워져 있는 경우
		if (isAllSame) {
			count[start + 1]++;
		}
		// 종이에 다른 숫자가 섞여 있는 경우 len/3으로 줄여서 9군데 모두 확인해본다.
		else {

			int nextLen = len / 3;
			int twice = nextLen * 2;

			countPaper(nowi, nowj, nextLen);
			countPaper(nowi + nextLen, nowj, nextLen);
			countPaper(nowi + twice, nowj, nextLen);
			countPaper(nowi, nowj + nextLen, nextLen);
			countPaper(nowi + nextLen, nowj + nextLen, nextLen);
			countPaper(nowi + twice, nowj + nextLen, nextLen);
			countPaper(nowi, nowj + twice, nextLen);
			countPaper(nowi + nextLen, nowj + twice, nextLen);
			countPaper(nowi + twice, nowj + twice, nextLen);
		}
	}

}