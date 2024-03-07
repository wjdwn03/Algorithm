import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static String A;
	static int C, B, aLen;
	static boolean[] isSelected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = st.nextToken();
		B = Integer.parseInt(st.nextToken());

		C = -1;
		aLen = A.length();
		isSelected = new boolean[aLen];

		perm("", 0);

		System.out.println(C);
	}

	private static void perm(String str, int cnt) {

		if (cnt == aLen) {
			int strToNum = Integer.parseInt(str);

			if (str.charAt(0) != '0' && strToNum < B) {
				C = Math.max(C, strToNum);
			}
			return;
		}

		for (int i = 0; i < aLen; i++) {
			if (isSelected[i])
				continue;
			isSelected[i] = true;
			perm(str + String.valueOf(A.charAt(i)), cnt + 1);
			isSelected[i] = false;
		}

	}

}