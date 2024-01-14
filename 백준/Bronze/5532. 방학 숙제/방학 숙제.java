import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int L = Integer.parseInt(br.readLine());
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		int D = Integer.parseInt(br.readLine());

		int kor = A / C;

		if (A % C != 0)
			kor++;

		int math = B / D;

		if (B % D != 0)
			math++;

		int ans = L - Math.max(kor, math);

		System.out.println(ans);
	}

}