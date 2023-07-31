import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int cnt = 0;
		double avg = 0;
		double sum = 0;

		while (st.countTokens() > 0) {
			String subject = st.nextToken();
			double grade = Double.parseDouble(st.nextToken());
			String score = st.nextToken();

			if (!score.equals("P")) {
				double scoreNum = scoreToNum(score);
				sum += (scoreNum * grade);
				cnt += grade;
			}

			String result = br.readLine();

			if (result == null || result.length() == 0) {
				break;
			}
			st = new StringTokenizer(result);

		} // end while

		System.out.println(sum / cnt);
	}

	private static double scoreToNum(String score) {

		if (score.equals("A+")) {
			return 4.5;
		} else if (score.equals("A0")) {
			return 4.0;
		} else if (score.equals("B+")) {
			return 3.5;
		} else if (score.equals("B0")) {
			return 3.0;
		} else if (score.equals("C+")) {
			return 2.5;
		} else if (score.equals("C0")) {
			return 2.0;
		} else if (score.equals("D+")) {
			return 1.5;
		} else if (score.equals("D0")) {
			return 1.0;
		} else {
			return 0.0;
		}

	}

}