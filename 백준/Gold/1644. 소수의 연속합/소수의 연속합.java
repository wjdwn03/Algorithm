import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static int N;
	static int cnt;
	static List<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		boolean[] prime = new boolean[N + 1];

		prime[0] = prime[1] = true;

		for (int i = 2; i <= Math.sqrt(N); i++) {
			for (int j = i * i; j <= N; j += i) {
				if (!prime[j])
					prime[j] = true;
			}
		}

		list = new ArrayList<>(); // 소수를 저장할 리스트

		for (int i = 0; i < N + 1; i++) {
			if (prime[i])
				continue;
			list.add(i);
		}
		cnt = 0;

		if (N > 1) {

			int start = 0, end = 0, sum = 0;
			int size = list.size();

			while (end < size) {

				sum += list.get(end++);

				if (sum == N)
					cnt++;

				while (sum > N && start <= end) {
					sum -= list.get(start++);

					if (sum == N)
						cnt++;
				}

			}

		}
		System.out.println(cnt);
	}

}
