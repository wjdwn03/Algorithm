import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= TC; tc++) {

			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int target = (1 << N) - 1;
			
			
			if (target == (M & target)) {
				sb.append("#").append(tc).append(" ON").append("\n");
			}
			else {
				sb.append("#").append(tc).append(" OFF").append("\n");
			}
		}
		System.out.print(sb.toString());
	}

}