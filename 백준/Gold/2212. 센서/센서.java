import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int ans = 0;

		if (n > k) {
			int[] sensor = new int[n];

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < n; i++) {
				sensor[i] = Integer.parseInt(st.nextToken());
			} // end input

			Arrays.sort(sensor);

			// 각 센서별 좌표차를 저장
			int[] diff = new int[n - 1];

			for (int i = 0; i < n - 1; i++) {
				diff[i] = sensor[i + 1] - sensor[i];
				ans += diff[i];
			}

			Arrays.sort(diff);

			// k개의 집중국 위치만큼 빼줌.
			for (int i = n - 2; i > n - 1 - k; i--) {
				ans -= diff[i];
			}
		}

		System.out.println(ans);

	}

}