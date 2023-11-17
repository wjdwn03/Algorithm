import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int k = Integer.parseInt(br.readLine());

		arr = new int[2][46];

		// A개수 입력
		arr[0][1] = 1;
		arr[0][2] = 1;

		// B개수 입력
		arr[1][0] = 1;
		arr[1][1] = 1;

		findCnt(arr, k - 1);

		sb.append(arr[0][k - 1]).append(" ").append(arr[1][k - 1]);

		System.out.println(sb.toString());

	}

	private static int[][] findCnt(int[][] arr, int k) {

		if (k < 2) {
			return arr;
		}

		if (arr[0][k] != 0 && arr[1][k] != 0)
			return arr;

		int[][] one = findCnt(arr, k - 1);
		int[][] two = findCnt(arr, k - 2);

		arr[0][k] = one[0][k - 1] + two[0][k - 2]; // A
		arr[1][k] = one[1][k - 1] + two[1][k - 2]; // B

		return arr;

	}

}