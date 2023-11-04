import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int[] W = new int[10];
		int[] K = new int[10];

		for (int i = 0; i < 10; i++) {
			W[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 0; i < 10; i++) {
			K[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(W);
		Arrays.sort(K);

		int w = W[9] + W[8] + W[7];
		int k = K[9] + K[8] + K[7];

		sb.append(w).append(" ").append(k);
		System.out.println(sb.toString());

	}

}