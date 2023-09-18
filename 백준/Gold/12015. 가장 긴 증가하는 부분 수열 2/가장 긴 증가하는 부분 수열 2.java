import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] A = new int[N];
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		arr[0] = A[0];

		int len = 1;

		for (int i = 1; i < N; i++) {

			int key = A[i];

			if (arr[len - 1] < key) {
				arr[len] = key;
				len++;
			} else {
				int start = 0;
				int end = len;

				while (start < end) {
					int mid = (start + end) / 2;

					if (arr[mid] < key) {
						start = mid + 1;
					} else {
						end = mid;
					}
				}

				arr[start] = key;
			}
		}

		System.out.println(len);
	}

}