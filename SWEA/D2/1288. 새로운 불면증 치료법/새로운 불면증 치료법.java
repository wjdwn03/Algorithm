import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		int target = (1 << 10) - 1;

		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(br.readLine());
			int cnt = 0;
			int result = 0;

			if (N != target) {
				for (cnt=1;; cnt++) {
					char[] str = Integer.toString(N*cnt).toCharArray();
					for(int j=0; j<str.length; j++) {
						result = result | (1 << (str[j]-'0'));
					}
					if (result == target)
						break;
				}
			}
			sb.append("#").append(tc).append(" ").append(cnt*N).append("\n");
		}
		System.out.println(sb.toString());
	}

}