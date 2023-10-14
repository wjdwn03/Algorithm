import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, L, cnt;
	static int[][] arr; // 지도
	static boolean[][] slope; // 경사로 설치 여부 저장할 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		cnt = 0; // 지나갈 수 있는 길의 개수

		arr = new int[N][N];
		slope = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end input

		rowCheck();
		slope = new boolean[N][N];
		colCheck();

		System.out.println(cnt);
	}

	private static void rowCheck() {

		int before = 0;
		int now = 0;
		boolean check = false;

		for (int i = 0; i < N; i++) {

			before = arr[i][0];
			check = true;

			for (int j = 1; j < N; j++) {
				now = arr[i][j];

				if (before != now) {
					// 높이가 1이상 차이 나서 경사로를 놓을 수 없는 경우
					if (Math.abs(before - now) > 1) {
						check = false;
						break;
					}
					// 높이가 1 차이 나는 경우
					else {
						// 예시) 222333
						if (before < now) {
							// 경사로를 놓다가 범위를 벗어나는 경우
							if (j - L < 0) {
								check = false;
								break;
							}

							for (int idx = j - L; idx < j; idx++) {
								// 경사로를 놓을 수 있는 경우
								// 경사로를 놓았다고 처리 해줌.
								if (!slope[i][idx] && before == arr[i][idx]) {
									slope[i][idx] = true;
								}
								// 만약 경사로가 이미 설치되어 있거나 경사로가 놓이는 칸의 높이가 다른 경우
								// 다시 경사로 설치 취소하기.
								else if (slope[i][idx] || before != arr[i][idx]) {
									for (int tmp = j - L; tmp < idx; tmp++) {
										slope[i][tmp] = false;
									}
									check = false;
									break;
								}
							}
						}
						// 예시) 333222
						else {
							// 경사로를 놓다가 범위를 벗어나는 경우
							if (j + L - 1 >= N) {
								check = false;
								break;
							}

							for (int idx = j; idx < j + L; idx++) {
								// 경사로를 놓을 수 있는 경우
								// 경사로를 놓았다고 처리 해줌.
								if (!slope[i][idx] && now == arr[i][idx]) {
									slope[i][idx] = true;
								}
								// 만약 경사로가 이미 설치되어 있거나 경사로가 놓이는 칸의 높이가 다른 경우
								// 다시 경사로 설치 취소하기.
								else if (slope[i][idx] || now != arr[i][idx]) {
									for (int tmp = j; tmp < idx; tmp++) {
										slope[i][tmp] = false;
									}
									check = false;
									break;
								}
							}
						}
					}
				}

				before = now;
			} // end for j

			if (check) {
				cnt++;
			}
		} // end for i

	}

	private static void colCheck() {

		int before = 0;
		int now = 0;
		boolean check = false;

		for (int j = 0; j < N; j++) {

			before = arr[0][j];
			check = true;

			for (int i = 1; i < N; i++) {
				now = arr[i][j];

				if (before != now) {
					// 높이가 1이상 차이 나서 경사로를 놓을 수 없는 경우
					if (Math.abs(before - now) > 1) {
						check = false;
						break;
					}
					// 높이가 1 차이 나는 경우
					else {
						// 예시) 222333
						if (before < now) {
							// 경사로를 놓다가 범위를 벗어나는 경우
							if (i - L < 0) {
								check = false;
								break;
							}

							for (int idx = i - L; idx < i; idx++) {
								// 경사로를 놓을 수 있는 경우
								// 경사로를 놓았다고 처리 해줌.
								if (!slope[idx][j] && before == arr[idx][j]) {
									slope[idx][j] = true;
								}
								// 만약 경사로가 이미 설치되어 있거나 경사로가 놓이는 칸의 높이가 다른 경우
								// 다시 경사로 설치 취소하기.
								else if (slope[idx][j] || before != arr[idx][j]) {
									for (int tmp = i - L; tmp < idx; tmp++) {
										slope[tmp][j] = false;
									}
									check = false;
									break;
								}
							}
						}
						// 예시) 333222
						else {
							// 경사로를 놓다가 범위를 벗어나는 경우
							if (i + L - 1 >= N) {
								check = false;
								break;
							}

							for (int idx = i; idx < i + L; idx++) {
								// 경사로를 놓을 수 있는 경우
								// 경사로를 놓았다고 처리 해줌.
								if (!slope[idx][j] && now == arr[idx][j]) {
									slope[idx][j] = true;
								}
								// 만약 경사로가 이미 설치되어 있거나 경사로가 놓이는 칸의 높이가 다른 경우
								// 다시 경사로 설치 취소하기.
								else if (slope[idx][j] || now != arr[idx][j]) {
									for (int tmp = i; tmp < idx; tmp++) {
										slope[tmp][j] = false;
									}
									check = false;
									break;
								}
							}
						}
					}
				}

				before = now;
			} // end for i

			if (check) {
				cnt++;
			}

		} // end for j
	}

}