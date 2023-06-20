import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String word = "";

		try {
			while ((word = br.readLine()) != null || !word.isEmpty()) {
				if (word.isEmpty()) // .size는 시간 복잡도가 N인데 isEmpty는 시간 복잡도가 1이다.
					break;
				sb.append(word).append("\n");

			}
		} catch (NullPointerException | NoSuchElementException e) {
			
		}
		System.out.print(sb.toString());
	}

}