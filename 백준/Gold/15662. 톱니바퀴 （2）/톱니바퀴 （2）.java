import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Gear {
	int num, dir;

	public Gear(int num, int dir) {
		this.num = num;
		this.dir = dir;
	}
}

public class Main {

	static int T;
	static List<Integer>[] list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		list = new LinkedList[T + 1];

		for (int t = 1; t <= T; t++) {
			String input = br.readLine();
			list[t] = new LinkedList<>(); // 초기화

			for (int i = 0; i < 8; i++) {
				list[t].add(input.charAt(i) - '0');
			}

		}

		int K = Integer.parseInt(br.readLine());

		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());

			int num = Integer.parseInt(st.nextToken()); // 톱니바퀴 번호
			int dir = Integer.parseInt(st.nextToken()); // 회전 방향

			// 회전할 톱니바퀴 모두 큐에 담아줌.
			Queue<Gear> queue = checkGear(num, dir);

			// 큐에 담긴 톱니바퀴 모두 회전시킴.
			rotate(queue);
		}

		int cnt = 0;

		for (int i = 1; i <= T; i++) {
			if (list[i].get(0) == 1)
				cnt++;
		}

		System.out.println(cnt);
	}

	private static void rotate(Queue<Gear> queue) {

		while (!queue.isEmpty()) {
			Gear cur = queue.poll();

			// 시계방향
			if (cur.dir == 1) {
				// 마지막에 들어있는 극을 꺼냄.
				int pole = list[cur.num].remove(7);
				list[cur.num].add(0, pole);
			}
			// 반시계방향
			else {
				int pole = list[cur.num].remove(0);
				list[cur.num].add(7, pole);
			}
		}

	}

	private static Queue<Gear> checkGear(int num, int dir) {

		Queue<Gear> queue = new ArrayDeque<>();

		queue.offer(new Gear(num, dir));

		int frontNum = num;
		int frontDir = dir;
		int backNum = num;
		int backDir = dir;

		// num 톱니바퀴 왼쪽 방향으로 가며 추가로 회전시켜야 하는 톱니바퀴 확인
		while (--frontNum >= 1) {

			// 맞닿은 극이 같은 경우
			if (list[frontNum + 1].get(6) == list[frontNum].get(2))
				break;

			frontDir *= -1;
			queue.offer(new Gear(frontNum, frontDir));
		}

		// num 톱니바퀴 오른쪽 방향으로 가며 추가로 회전시켜야 하는 톱니바퀴 확인
		while (++backNum <= T) {

			// 맞닿은 극이 같은 경우
			if (list[backNum - 1].get(2) == list[backNum].get(6))
				break;

			backDir *= -1;
			queue.offer(new Gear(backNum, backDir));
		}

		return queue;
	}

}