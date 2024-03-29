import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String jinho = br.readLine();

		int N = Integer.parseInt(br.readLine());
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			if (jinho.equals(br.readLine()))
				cnt++;
		}

		System.out.println(cnt);

	}

}