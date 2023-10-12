import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M, max, price;
	static int[] P;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		max = 0; // 최대 수익
		price = 0; // 책정한 가격
		P = new int[M];

		for (int i = 0; i < M; i++) {
			P[i] = Integer.parseInt(br.readLine());
		} // end input

		// 오름차순으로 정렬하여 책정한 가격을 최소 가격부터 차근 차근 계산해본다.
		Arrays.sort(P);

		// P[i]에 num을 곱하면 살 수 있는 최대한의 개수로 달걀을 살 수 있다.
		int num = N;

		if (N > M) {
			num = M;
		}

		for (int i = 0; i < M; i++) {

			int tmp = 0; // 임시로 수익을 저장할 변수

			// num을 더한 값이 P 배열의 범위 안에 있을 때는 num과 P[i]를 곱해서
			// 가능한 최대 개수로 달걀을 구매한다.
			if (i + num <= M) {
				tmp = num * P[i];
			}
			// 만약 범위 밖이라면 현재 위치에서부터 P 배열의 끝까지 남은 개수에다가 P[i]를 곱해서 구매한다.
			else {
				tmp = (M - i) * P[i];
			}

			// 최대 수익보다 많은 경우 갱신
			if (tmp > max) {
				max = tmp;
				price = P[i];
			}
		} // end for

		sb.append(price).append(" ").append(max);

		System.out.println(sb.toString());

	}

}