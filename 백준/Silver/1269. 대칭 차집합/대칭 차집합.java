import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int Acnt = Integer.parseInt(st.nextToken());
		int Bcnt = Integer.parseInt(st.nextToken());

		HashSet<Integer> hashSet = new HashSet<>(); // A, B 집합 모두 여기에 담음.
		List<Integer> list = new ArrayList<>(); // 중복된 값들은 여기에 추가

		st = new StringTokenizer(br.readLine());

		int num = 0;

		for (int i = 0; i < Acnt; i++) {
			num = Integer.parseInt(st.nextToken());

			if (hashSet.contains(num)) {
				list.add(num);
				continue;
			}
			hashSet.add(num);
		}

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < Bcnt; i++) {
			num = Integer.parseInt(st.nextToken());

			if (hashSet.contains(num)) {
				list.add(num);
				continue;
			}
			hashSet.add(num);
		}

		System.out.println(hashSet.size() - list.size());

	}

}