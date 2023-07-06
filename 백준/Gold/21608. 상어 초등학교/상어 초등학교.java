import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] classroom;
	static int[][] student;
	static Point[][] search;
	static List<Point> likeList;
	static List<Point> emptyList;
	static List<Point> minRowList;
	static List<Point> minColList;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		classroom = new int[N + 1][N + 1]; // 자리가 정해진 자리배치도
		student = new int[N * N][5]; // 좋아하는 학생 번호 저장 배열

		for (int i = 0; i < N * N; i++) {
			st = new StringTokenizer(br.readLine());


			student[i][0] = Integer.parseInt(st.nextToken());
			student[i][1] = Integer.parseInt(st.nextToken());
			student[i][2] = Integer.parseInt(st.nextToken());
			student[i][3] = Integer.parseInt(st.nextToken());
			student[i][4] = Integer.parseInt(st.nextToken());
		} // end input

		// 자리 지정
		for (int i = 0; i < N * N; i++) {
			
			search = new Point[N + 1][N + 1]; // 인접한 칸에 비어있는 칸 수와 좋아하는 학생 수 저장할 배열
			likeList = new ArrayList<>();
			emptyList = new ArrayList<>();
			minRowList = new ArrayList<>();
			minColList = new ArrayList<>();

			if (one(i)) {
				continue;
			} else {
				if (two(i)) {
					continue;
				} else {
					three(i);
				}
			}
		}

		int ans = check();
		
		System.out.println(ans);

	}

	private static int check() {

		int ans = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {

				int like = 0;
				int idx = 0;
				
				// 어떤 학생의 만족도를 구하는 건지 찾기
				for (int ii = 0; ii < N * N; ii++) {
					if (student[ii][0] == classroom[i][j])
						idx = ii;
				}

				// 주변에 좋아하는 학생 수 세기
				for (int d = 0; d < 4; d++) {
					int nexti = i + di[d];
					int nextj = j + dj[d];

					if (nexti < 1 || nexti > N || nextj < 1 || nextj > N) {
						continue;
					}

					for (int s = 1; s < 5; s++) {
						if (student[idx][s] == classroom[nexti][nextj]) {
							like++;
						}
					}

				} // end for d

				switch (like) {
				case 0:
					break;
				case 1:
					ans += 1;
					break;
				case 2:
					ans += 10;
					break;
				case 3:
					ans += 100;
					break;
				default:
					ans += 1000;
					break;
				}

			} // end for j
		} // end for i

		return ans;
	}

	private static void three(int idx) {

		int minRow = N + 1, minCol = N + 1;
		if (emptyList.size() == 0) {

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (classroom[i][j] == 0 && i <= minRow) {
						if (minRow != i) {
							minRow = i;
							minRowList.clear();
						}
						minRowList.add(new Point(i, j, -1, -1));
					}
				} // end for j
			} // end for i
		} // end if emptyList.size==0

		else if (emptyList.size() > 1) {
			for (int i = 0; i < emptyList.size(); i++) {

				if (emptyList.get(i).i <= minRow) {

					if (emptyList.get(i).i != minRow) {
						minRow = emptyList.get(i).i;
						minRowList.clear();
					}
					minRowList.add(new Point(emptyList.get(i).i, emptyList.get(i).j, -1, -1));
				}
			}
		} // end else if

		if (minRowList.size() == 1) {
			classroom[minRowList.get(0).i][minRowList.get(0).j] = student[idx][0];
		}

		else {
			for (int i = 0; i < minRowList.size(); i++) {
				if (minRowList.get(i).j <= minCol) {

					if (minRowList.get(i).j != minCol) {
						minCol = minRowList.get(i).j;
						minColList.clear();
					}

					minColList.add(new Point(minRowList.get(i).i, minRowList.get(i).j, -1, -1));
				}
			} // end for i
		} // end else

		if(minColList.size()==1) {
			
			classroom[minColList.get(0).i][minColList.get(0).j] = student[idx][0];
		}
	}

	private static boolean two(int idx) {

		if (likeList.size() > 1) {

			emptyList.clear();
			int emptyMax = -1;

			for (int i = 0; i < likeList.size(); i++) {
				if (likeList.get(i).empty >= emptyMax) {

					if (likeList.get(i).empty != emptyMax) {
						emptyMax = likeList.get(i).empty;
						emptyList.clear();
					}
					emptyList.add(new Point(likeList.get(i).i, likeList.get(i).j, emptyMax, likeList.get(i).like));
				}
			} // end for i
		}

		if (emptyList.size() == 1) {
			classroom[emptyList.get(0).i][emptyList.get(0).j] = student[idx][0];
			return true;
		}

		return false;
	}

	private static boolean one(int idx) {

		int maxLike = -1, maxEmpty = -1;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {

				int empty = 0; // 비어있는 인접한 칸의 수
				int like = 0; // 좋아하는 학생이 있는 인접한 칸의 수
				
				if(classroom[i][j] != 0) {
					continue;
				}

				for (int d = 0; d < 4; d++) {
					int nexti = i + di[d];
					int nextj = j + dj[d];
					if (nexti < 1 || nexti > N || nextj < 1 || nextj > N) {
						continue;
					}
					if (classroom[nexti][nextj] == 0) {
						empty++;
						continue;
					}

					for (int s = 1; s < 5; s++) {
						if (classroom[nexti][nextj] == student[idx][s]) {
							like++;
						}
					} // end for s
				} // end for d

				search[i][j] = new Point(i, j, empty, like);

				if (maxLike <= like) {

					if (maxLike != like) {
						maxLike = like;
						likeList.clear();
					}
					likeList.add(new Point(i, j, empty, like));
                }

				if (maxEmpty <= empty) {

					if (maxEmpty != empty) {
						maxEmpty = empty;
						emptyList.clear();
					}
					emptyList.add(new Point(i, j, empty, like));
				}

			} // end for j
		} // end for i

		if (likeList.size() == 1) {
			classroom[likeList.get(0).i][likeList.get(0).j] = student[idx][0];
			return true;
		}

		return false;
	}

	private static class Point {
		int i, j, empty, like;

		public Point(int i, int j, int empty, int like) {
			this.i = i;
			this.j = j;
			this.empty = empty;
			this.like = like;
		}
	}

}