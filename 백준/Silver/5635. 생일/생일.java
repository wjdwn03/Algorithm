import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		List<Student> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int day = Integer.parseInt(st.nextToken());
			int month = Integer.parseInt(st.nextToken());
			int year = Integer.parseInt(st.nextToken());

			list.add(new Student(name, day, month, year));
		}

		Collections.sort(list);
		sb.append(list.get(N - 1).name).append("\n").append(list.get(0).name);

		System.out.println(sb.toString());
	}

	static class Student implements Comparable<Student> {
		String name;
		int day, month, year;

		public Student(String name, int day, int month, int year) {
			this.name = name;
			this.day = day;
			this.month = month;
			this.year = year;
		}

		@Override
		public int compareTo(Student o) {
			if (this.year == o.year) {
				if (this.month == o.month) {
					return this.day - o.day;
				} else {
					return this.month - o.month;
				}
			}
			return this.year - o.year;
		}
	}

}