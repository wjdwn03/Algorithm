import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());

		TreeSet<Integer> treeSet = new TreeSet<>();

		for (int i = 0; i < N; i++) {
			treeSet.add(Integer.parseInt(st.nextToken()));
		}

		for (int i = 0; i < N; i++) {
			if (treeSet.isEmpty()) {
				break;
			}
			sb.append(treeSet.pollFirst()).append(" ");
		}
		System.out.println(sb.toString());
	}

}