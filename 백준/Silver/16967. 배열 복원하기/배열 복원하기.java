import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());

		int[][] B = new int[H + X][W + Y];
		int[][] A = new int[H][W];

		for (int i = 0; i < H + X; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W + Y; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end input

		for (int i = 0; i < X; i++) {
			for (int j = 0; j < W; j++) {
				A[i][j] = B[i][j];
			}
		}

		for (int i = X; i < H; i++) {
			for (int j = 0; j < Y; j++) {
				A[i][j] = B[i][j];
			}
			for (int j = Y; j < W; j++) {
				A[i][j] = B[i][j] - A[i - X][j - Y];
			}
		}

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				sb.append(A[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

}