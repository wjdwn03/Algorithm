import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, K, step, zeroCnt, two;
	static int[] belt;
	static int[] A;
	static boolean[] zeroCheck;
	static Queue<Integer> robot;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		two = 2 * N;

		belt = new int[two]; // 컨베이어 벨트, 1 : 로봇 있음, 0 : 로봇 없음.
		A = new int[two]; // 내구도 저장 배열
		zeroCheck = new boolean[two];
		zeroCnt = 0;
		step = 0;

		robot = new ArrayDeque<>();

		st = new StringTokenizer(br.readLine());

		// 내구도 입력
		for (int i = 0; i < two; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		while (zeroCnt < K) {

			// 1단계 벨트 회전
			rotateBelt();

			// 2단계
			int size = robot.size();
			int cnt = 0;

			int idx = 0;

			while (cnt < size) {
				int cur = robot.poll();

				if (cur >= N - 1) {
					cnt++;
					belt[cur] = 0;
					continue;
				}

				if (cur >= two - 1) {
					idx = 0;
				} else {
					idx = cur + 1;
				}
				// 이동 못하는 경우
				if (belt[idx] == 1 || A[idx] == 0) {
					robot.offer(cur);
				}
				// 이동하는 경우
				else {
					robot.offer(idx);
					belt[cur] = 0;
					belt[idx] = 1;
					A[idx]--;
					if (A[idx] == 0) {
						zeroCnt++;
					}
				}

				cnt++;
			} // end while

			// 3단계
			if (A[0] > 0) {
				robot.offer(0);
				belt[0] = 1;
				A[0]--;

				if (A[0] == 0) {
					zeroCnt++;
				}
			}

			step++;
		} // end while

		System.out.println(step);
	}

	private static void rotateBelt() {

		int beltTmp = belt[two - 1];
		int Atmp = A[two - 1];

		for (int i = two - 1; i > 0; i--) {
			if (i >= N) {
				belt[i] = 0;
			} else {
				belt[i] = belt[i - 1];
			}
			A[i] = A[i - 1];
		}

		belt[0] = beltTmp;
		A[0] = Atmp;

		int size = robot.size();
		int cnt = 0;

		while (cnt < size) {
			int idx = robot.poll();

			if (idx >= N) {
				belt[idx] = 0;
				cnt++;
				continue;
			}

			robot.offer(idx + 1);
			cnt++;

		}

	}

}