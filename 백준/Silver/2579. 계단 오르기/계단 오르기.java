import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int N;
	static int[] stair;
	static int[] max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		stair = new int[301]; // N이 2나 3이면 ArrayIndexOutOfBounds 에러 발생하기 때문에 N의 최댓값 + 1로 길이 지정함.
		max = new int[301];

		for (int i = 1; i <= N; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}

		max[1] = stair[1];
		max[2] = stair[1] + stair[2];
		max[3] = stair[3] + Math.max(stair[1], stair[2]);

		for (int i = 4; i <= N; i++) {
			max[i] = stair[i] + Math.max(max[i - 3] + stair[i - 1], max[i - 2]);
		}

		System.out.println(max[N]);
	}

}
