import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int k;
	static long min, max;
	static String minStr, maxStr;
	static char[] arr;
	static boolean[] isSelected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		k = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int idx = 0;
		arr = new char[k];
		isSelected = new boolean[10];

		while (st.hasMoreTokens()) {
			arr[idx++] = st.nextToken().charAt(0);
		} // end input

		min = 9999999999L;
		max = 0L;
		minStr = " ";
		maxStr = " ";
		perm(0, "");

		sb.append(maxStr).append("\n").append(minStr);
		System.out.println(sb.toString());

	}

	private static void perm(int cnt, String num) {

		if (cnt == k + 1) {
			checkNumber(num);
		}

		for (int i = 0; i < 10; i++) {
			if (isSelected[i])
				continue;

			isSelected[i] = true;
			perm(cnt + 1, num + String.valueOf(i));
			isSelected[i] = false;
		}

	}

	private static void checkNumber(String num) {

		int a = 0;
		int b = 0;
		char inequality = ' ';
		boolean check = true;

		for (int i = 0; i < k; i++) {
			a = num.charAt(i) - '0';
			b = num.charAt(i + 1) - '0';
			inequality = arr[i];

			if (inequality == '<') {
				if (a > b) {
					check = false;
					break;
				}
			} else {
				if (a < b) {
					check = false;
					break;
				}
			}

		}

		if (check) {
			long tmp = Long.parseLong(num);

			if (min > tmp) {
				min = tmp;
				minStr = num;
			} else if (max < tmp) {
				max = tmp;
				maxStr = num;
			}
		}
	}

}