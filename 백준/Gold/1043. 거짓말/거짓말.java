import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M, ans, truthCnt;
	static int[] truth; // 진실을 아는 사람들을 저장할 배열
	static HashSet<Integer> set;
	static List<Integer>[] list; // 서로 연결된 사람들 저장할 인접리스트
	static List<Party> partyList; // 파티에 오는 사람들 저장할 리스트
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		set = new HashSet<>();
		ans = 0;
		visit = new boolean[N + 1];

		st = new StringTokenizer(br.readLine());

		truthCnt = Integer.parseInt(st.nextToken());

		if (truthCnt == 0) {
			ans = M;
		} else {
			truth = new int[truthCnt];
			list = new LinkedList[N + 1];
			partyList = new ArrayList<>();

			// initialization
			for (int i = 1; i <= N; i++) {
				list[i] = new LinkedList<>();
			}

			// 진실을 아는 사람들 저장
			for (int i = 0; i < truthCnt; i++) {
				truth[i] = Integer.parseInt(st.nextToken());
				set.add(truth[i]);
			}

			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());

				int cnt = Integer.parseInt(st.nextToken());
				int[] arr = new int[cnt];
				boolean check = false; // 진실을 알고 있는 사람이 있는지

				for (int i = 0; i < cnt; i++) {
					arr[i] = Integer.parseInt(st.nextToken());
					if (set.contains(arr[i]))
						check = true;
				}

				// 서로 연결된 사람들 추가
				for (int i = 0; i < cnt; i++) {
					for (int j = 0; j < cnt; j++) {
						if (i == j)
							continue;

						list[arr[i]].add(arr[j]);
						list[arr[j]].add(arr[i]);
					}
				}

				// 진실을 알고 있는 사람이 없는 경우에만 추가
				// 우선적으로 거르는 단계
				if (!check) {
					partyList.add(new Party(cnt, arr));
				}
			} // end for m

			if (!partyList.isEmpty()) {

				// 진실을 들은 사람들 체크

				for (int i = 0; i < truthCnt; i++) {
					dfs(truth[i]);
				}

				for (Party now : partyList) {

					boolean isLier = true;

					for (int i = 0; i < now.cnt; i++) {
						if (visit[now.arr[i]]) {
							isLier = false;
							break;
						}
					}

					if (isLier)
						ans++;
				}
			}

		} // end else

		System.out.println(ans);
	}

	private static void dfs(int person) {

		if (visit[person])
			return;

		visit[person] = true;

		for (int next : list[person]) {
			dfs(next);
		}

	}

}

class Party {
	int cnt;
	int[] arr;

	public Party(int cnt, int[] arr) {
		this.cnt = cnt;
		this.arr = arr;
	}
}