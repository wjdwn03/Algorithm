import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Score implements Comparable<Score> {
	int kor, eng, math;
	String name;

	public Score(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	@Override
	public int compareTo(Score o) {

		if (this.kor == o.kor && this.eng == o.eng && this.math == o.math) {
			return this.name.compareTo(o.name);
		} else if (this.kor == o.kor && this.eng == o.eng) {
			return o.math - this.math;
		} else if (this.kor == o.kor) {
			return this.eng - o.eng;
		}
		return o.kor - this.kor;
	}
}

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		Queue<Score> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			String name = st.nextToken();
			int kor = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());

			pq.offer(new Score(name, kor, eng, math));
		}

		while (!pq.isEmpty()) {
			Score now = pq.poll();

			sb.append(now.name).append("\n");
		}

		System.out.println(sb.toString());

	}

}