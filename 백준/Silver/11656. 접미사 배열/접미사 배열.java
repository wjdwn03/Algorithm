import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String S = br.readLine();
		int size = S.length();
		String[] arr = new String[size];

		for (int i = 0; i < size; i++) {
			arr[i] = S.substring(i);
		}

		Arrays.sort(arr);

		for (int i = 0; i < size; i++) {
			sb.append(arr[i]).append("\n");
		}

		System.out.println(sb.toString());

	}

}