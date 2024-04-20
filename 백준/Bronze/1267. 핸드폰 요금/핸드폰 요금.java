import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());

		long ySum = 0, mSum = 0;

		for (int i = 0; i < N; i++) {
			int time = Integer.parseInt(st.nextToken());

			ySum += (long) ((time / 30) + 1) * 10;
			mSum += (long) ((time / 60) + 1) * 15;
		}

		if (ySum == mSum)
			sb.append("Y").append(" ").append("M").append(" ").append(ySum);
		else if (ySum > mSum)
			sb.append("M").append(" ").append(mSum);
		else
			sb.append("Y").append(" ").append(ySum);

		System.out.println(sb.toString());

	}

}