import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		double energy = 0;
		int num = 0;
		int max = 0;
		
		for (int i = 0; i < N; i++) {
			num = Integer.parseInt(st.nextToken());
			max = Math.max(max, num);
			energy += num;
		}

		double ans = max + (energy-max) / 2.0;
		
		System.out.println(ans);
	}

}