import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		double H = Double.parseDouble(st.nextToken());
		double W = Double.parseDouble(st.nextToken());
		double N = Double.parseDouble(st.nextToken());
		double M = Double.parseDouble(st.nextToken());

		System.out.println(Math.round(Math.ceil(H / (N + 1)) * Math.ceil(W / (M + 1))));
	}

}