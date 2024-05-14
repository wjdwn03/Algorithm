import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String[] tunnelIn = new String[N];

		Set<String> set = new HashSet<>(); //

		// 터널 in
		for (int i = 0; i < N; i++) {
			tunnelIn[i] = br.readLine();
		}

		int cnt = 0, lastIdx = 0;

		// 터널 들어간 순서대로 앞에서부터 확인
		for (int i = 0; i < N; i++) {

			if (!set.contains(tunnelIn[i])) {
				int start = lastIdx;

				// 투포인터 느낌으로 풂.
				while (lastIdx < N) {

					String car = br.readLine(); // 터널에서 나오는 차
					set.add(car);

					// start ~ tunnelIn[i]와 동일한 차가 나오기 직전까지 모두 추월한 차량임.
					if (tunnelIn[i].equals(car)) {
						cnt += (lastIdx - start);
						break;
					}

					lastIdx++;
				}
			}
		}

		System.out.println(cnt);
	}

}