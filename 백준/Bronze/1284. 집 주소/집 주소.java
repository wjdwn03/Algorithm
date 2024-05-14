import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String num = "";

		while (!((num = br.readLine()).equals("0"))) {
			char[] eachNum = num.toCharArray();
			int width = 2 + eachNum.length - 1;

			for (char now : eachNum) {
				if (now == '1')
					width += 2;
				else if (now == '0')
					width += 4;
				else
					width += 3;

			}

			sb.append(width).append("\n");
		}

		System.out.println(sb.toString());
	}

}