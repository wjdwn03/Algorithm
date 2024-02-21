import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		Ant ant = new Ant();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int k = Integer.parseInt(st.nextToken());
			String[] arr = new String[k];

			for (int j = 0; j < k; j++) {
				arr[j] = st.nextToken();
			}

			ant.add(arr);
		}

		ant.print(ant.root, 0);

		System.out.println(sb.toString());

	}

	static class Node {
		Map<String, Node> child = new HashMap<>();
	}

	static class Ant {
		private Node root;

		public Ant() {
			root = new Node();
		}

		// 자식 노드 추가
		void add(String[] str) {

			// 항상 루트 노드에서 시작해야 함.
			Node node = this.root;

			for (String word : str) {
				// 문자열이 자식 노드 중에 있는 지 확인하고 없으면 자식 노드 생성
				node = node.child.computeIfAbsent(word, k -> new Node());
			}
		}

		// 문자열 검색
		void print(Node cur, int depth) {

			if (cur.child != null) {
				List<String> list = new ArrayList<>(cur.child.keySet());
				Collections.sort(list);
				for (String str : list) {
					for (int i = 0; i < depth; i++) {
						sb.append("--");
					}
					sb.append(str).append("\n");
					print(cur.child.get(str), depth + 1);
				}
			}
		}
	}
}