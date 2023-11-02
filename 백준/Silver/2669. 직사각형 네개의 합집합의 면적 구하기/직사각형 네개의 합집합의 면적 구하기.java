import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int x1, x2, y1, y2;
		int[][] arr = new int[101][101];
		int cnt = 0;

		for (int t = 0; t < 4; t++) {
			st = new StringTokenizer(br.readLine());

			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

			for (int i = y1; i < y2; i++) {
				for (int j = x1; j < x2; j++) {
					if (arr[i][j] == 1)
						continue;
					arr[i][j] = 1;
					cnt++;
				}
			}
		}

		System.out.println(cnt);
	}

}