import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, L, cnt;
	static int[][] rowMap, colMap; // 지도

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		cnt = 0; // 지나갈 수 있는 길의 개수

		rowMap = new int[N][N];
		colMap = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				rowMap[i][j] = Integer.parseInt(st.nextToken());
				colMap[j][i] = rowMap[i][j]; // 열과 행을 반대로도 적어줌.
			}
		} // end input

		// 행 확인
		for (int i = 0; i < N; i++) {
			// 행 확인
            lineCheck(rowMap[i]);
            // 열 확인
            lineCheck(colMap[i]);
		}

		System.out.println(cnt);
	}

	private static void lineCheck(int[] line) {

		boolean[] slope = new boolean[N];
		int before = line[0];
		int now = 0;

		for (int i = 1; i < N; i++) {
			now = line[i];

			if (before == now)
				continue;
			// 1 이상 차이나는 경우 경사로 설치 못함.
			else if (Math.abs(before - now) > 1)
				return;
			// 1 차이나는 경우
			else {
				// 오르막
				if (before < now) {
					// 경사로를 놓다가 범위를 벗어나는 경우
					if (i - L < 0) {
						return;
					}
					for (int idx = i - L; idx < i; idx++) {
						// 경사로를 놓을 수 있는 경우
						// 경사로를 놓았다고 처리 해줌.
						if (!slope[idx] && before == line[idx]) {
							slope[idx] = true;
						}
						// 만약 경사로가 이미 설치되어 있거나 경사로가 놓이는 칸의 높이가 다른 경우
						else if (slope[idx] || before != line[idx]) {
							return;
						}
					}
				}
				// 내리막
				else {
					// 경사로를 놓다가 범위를 벗어나는 경우
					if (i + L - 1 >= N) {
						return;
					}

					for (int idx = i; idx < i + L; idx++) {
						// 경사로를 놓을 수 있는 경우
						// 경사로를 놓았다고 처리 해줌.
						if (!slope[idx] && now == line[idx]) {
							slope[idx] = true;
						}
						// 만약 경사로가 이미 설치되어 있거나 경사로가 놓이는 칸의 높이가 다른 경우
						else if (slope[idx] || now != line[idx]) {
							return;
						}
					}
				}
			}

			before = now;
		}

		cnt++;
	}

}