import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			parent[i] = i;
		}

		List<City> list = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list.add(new City(a, b, c));
		}

		Collections.sort(list);

		int ans = 0;
		int lastC = 0;

		for (int i = 0; i < M; i++) {

			City now = list.get(i);

			if (find(now.a) != find(now.b)) {
				lastC = now.c;
				ans += now.c;
				union(now.a, now.b);
			}
		}

		System.out.println(ans - lastC);
	}

	public static int find(int i) {
		if (parent[i] == i)
			return i;
		return parent[i] = find(parent[i]);
	}

	public static void union(int a, int b) {
		int aParent = find(a);
		int bParent = find(b);

		if (aParent < bParent) {
			parent[bParent] = aParent;
		} else {
			parent[aParent] = bParent;
		}
	}

	static class City implements Comparable<City> {
		int a, b, c;

		public City(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public int compareTo(City o) {
			return this.c - o.c;
		}
	}

}