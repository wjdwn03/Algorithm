import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		int[] x = new int[N + 1];
		int[] y = new int[N + 1];
		int maxX = 0, maxY = 0, maxXCnt = 0, maxYCnt = 0;

		for (int q = 0; q < Q; q++) {
			st = new StringTokenizer(br.readLine());

			int t = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());

			if (N == 1) {
				sb.append(1).append("\n");
			} else {

				if (t == 1) {
					x[a]++;

					if (maxX == x[a])
						maxXCnt++;
					else if (maxX < x[a]) {
						maxXCnt = 1;
						maxX = x[a];
					}

				} else {
					y[a]++;

					if (maxY == y[a])
						maxYCnt++;
					else if (maxY < y[a]) {
						maxYCnt = 1;
						maxY = y[a];
					}
				}

				if (maxX == 0) {
					sb.append(maxYCnt * N);
				} else if (maxY == 0) {
					sb.append(maxXCnt * N);
				} else {
					sb.append(maxXCnt * maxYCnt);
				}

				sb.append("\n");
			}
		}

		System.out.println(sb);
	}

}