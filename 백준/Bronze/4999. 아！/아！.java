import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String jae = br.readLine();

		int size = jae.length();
		int aCnt = 0, hCnt = 0;

		for (int i = 0; i < size; i++) {

			char now = jae.charAt(i);
			if (now == 'a')
				aCnt++;
			else
				hCnt++;
		}

		String doc = br.readLine();

		int aDoc = 0;
		int hDoc = 0;

		size = doc.length();

		for (int i = 0; i < size; i++) {
			char now = doc.charAt(i);

			if (now == 'a')
				aDoc++;
			else
				hDoc++;
		}

		if (aCnt >= aDoc && hCnt >= hDoc)
			System.out.println("go");
		else
			System.out.println("no");
	}

}