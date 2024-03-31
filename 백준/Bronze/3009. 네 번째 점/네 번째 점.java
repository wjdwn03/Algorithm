import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int[][] point = new int[3][3];
		point[0][0] = Integer.parseInt(st.nextToken());
		point[0][1] = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= 2; i++) {
			st = new StringTokenizer(br.readLine());

			point[i][0] = Integer.parseInt(st.nextToken());
			point[i][1] = Integer.parseInt(st.nextToken());
		}

		int x = 0, y = 0;

		if (point[0][0] == point[1][0])
			x = point[2][0];
		else if (point[1][0] == point[2][0])
			x = point[0][0];
		else
			x = point[1][0];

		if (point[0][1] == point[1][1])
			y = point[2][1];
		else if (point[1][1] == point[2][1])
			y = point[0][1];
		else
			y = point[1][1];

		sb.append(x).append(" ").append(y);

		System.out.println(sb.toString());
	}

}