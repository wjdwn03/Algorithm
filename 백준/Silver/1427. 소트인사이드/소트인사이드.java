import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String num = br.readLine();

		Integer[] arr = new Integer[num.length()];

		for (int i = 0; i < num.length(); i++) {
			arr[i] = num.charAt(i) - '0';
		}

		Arrays.sort(arr, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}

		});

		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
		}

		System.out.println(sb.toString());

	}

}