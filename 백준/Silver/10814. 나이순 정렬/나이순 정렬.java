import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		User[] user = new User[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();

			user[i] = new User(age, name);
		}

		Arrays.sort(user);

		for (int i = 0; i < N; i++) {
			sb.append(user[i].age).append(" ").append(user[i].name).append("\n");
		}

		System.out.println(sb.toString());
	}

	static class User implements Comparable<User> {
		int age;
		String name;

		public User(int age, String name) {
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(User o) {
			return this.age - o.age;
		}
	}

}