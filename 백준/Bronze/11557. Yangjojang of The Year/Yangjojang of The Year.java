import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Drink implements Comparable<Drink> {
	String school;
	int l;

	public Drink(String school, int l) {
		this.school = school;
		this.l = l;
	}

	@Override
	public int compareTo(Drink o) {
		// TODO Auto-generated method stub
		return o.l - this.l;
	}
}

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			Queue<Drink> pq = new PriorityQueue<>();

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());

				pq.offer(new Drink(st.nextToken(), Integer.parseInt(st.nextToken())));
			}

			sb.append(pq.poll().school).append("\n");
		}

		System.out.println(sb);

	}

}