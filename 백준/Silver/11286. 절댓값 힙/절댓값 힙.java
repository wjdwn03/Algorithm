import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 연산 개수

		PriorityQueue<Integer> queueAsc = new PriorityQueue<>(); // 오름차순 담아줄 우선순위 큐
		PriorityQueue<Integer> queueDesc = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순 담아줄 우선순위 큐

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			int numAbs = Math.abs(num);

			if (num != 0) { // 0이 아닌 경우 큐에 추가해준다.
				if (num < 0) { // 0보다 작은 경우 내림차순
					queueDesc.offer(num);
				} else { // 0보다 큰 경우 오름차순
					queueAsc.offer(num);
				}
			} else { // 0인 경우 큐에서 절대값이 가장 작은 값을 제거한다.
				
				// 큐가 비어 있으면 0 출력
				if (queueDesc.isEmpty() && queueAsc.isEmpty()) {
					sb.append(0).append("\n");
					continue;
				} 
				
				// 음수가 없고 양수만 있는 경우 오름차순 큐에서 poll
				else if (queueDesc.isEmpty() && !queueAsc.isEmpty()) {
					sb.append(queueAsc.poll()).append("\n");
					continue;
				}
				
				// 내림차순 큐가 비어있지 않은 경우
				else if (!queueDesc.isEmpty()) {
					
					// 만약 양수 큐가 비어 있다면 내림 차순 큐에서 poll
					if (queueAsc.isEmpty()) {
						sb.append(queueDesc.poll()).append("\n");
					}
					
					// 양수 큐가 비어 있지 않으면 두 개의 큐에서 절대값을 비교해봐야 한다.
					else {

						if (Math.abs(queueAsc.peek()) < Math.abs(queueDesc.peek())) {
							sb.append(queueAsc.poll()).append("\n");
						} else {

							sb.append(queueDesc.poll()).append("\n");
						}
					}
				}

			}

		}
		System.out.println(sb.toString());
	}

}