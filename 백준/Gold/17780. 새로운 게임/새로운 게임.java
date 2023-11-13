import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, K, ans;
	static int[][] chessboard; // 체스판 색깔 표시
	static Deque<Piece>[][] map; // 체스판에 말 표시
	static Piece[] pieces; // 각 체스말별로 위치 표시
	static int[] di = { 0, 0, 0, -1, 1 };
	static int[] dj = { 0, 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		ans = -1;

		chessboard = new int[N + 1][N + 1];
		pieces = new Piece[K + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				chessboard[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		map = new ArrayDeque[N + 1][N + 1];

		// 초기화
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				map[i][j] = new ArrayDeque<>();
			}
		}

		for (int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());

			map[r][c].addLast(new Piece(i));

			pieces[i] = new Piece(r, c, dir);
		} // end input

		for (int i = 1; i < 1001; i++) {

			if (move(i)) {
				ans = i;
				break;
			}

		}

		System.out.println(ans);

	}

	private static boolean move(int tmp) {

		int nowi = 0, nowj = 0, nexti = 0, nextj = 0, dir = 0;

		for (int k = 1; k <= K; k++) {
			nowi = pieces[k].row;
			nowj = pieces[k].col;
			dir = pieces[k].dir;

			nexti = nowi + di[dir];
			nextj = nowj + dj[dir];

			// k번 체스말이 2층 이상에 위치하고 있다면 continue
			if (map[nowi][nowj].peekFirst().num != k)
				continue;

			// 범위 밖이거나 파란색인 경우
			if (nexti <= 0 || nexti > N || nextj <= 0 || nextj > N || chessboard[nexti][nextj] == 2) {

				// 우선 방향 전환
				dir = reverseDir(dir);

				// 다음 위치 다시 확인
				nexti = nowi + di[dir];
				nextj = nowj + dj[dir];

				if (nexti <= 0 || nexti > N || nextj <= 0 || nextj > N || chessboard[nexti][nextj] == 2) {
					nexti = nowi;
					nextj = nowj;
				} else if (chessboard[nexti][nextj] == 0) {
					whiteAndRed(nowi, nowj, nexti, nextj, k, false);

				} else {
					whiteAndRed(nowi, nowj, nexti, nextj, k, true);
				}

			} // end blue

			// white
			else if (chessboard[nexti][nextj] == 0) {

				whiteAndRed(nowi, nowj, nexti, nextj, k, false);
			}

			// red
			else {

				whiteAndRed(nowi, nowj, nexti, nextj, k, true);

			}

			// 방향 갱신
			pieces[k].dir = dir;

			// 매번 말을 움직일 때마다 말의 개수 확인
			if (map[nexti][nextj].size() >= 4) {
				return true;
			}
		}

		return false;
	}

	private static void whiteAndRed(int nowi, int nowj, int nexti, int nextj, int k, boolean reverse) {
		// now위치에 있는 k번 말과 그 위에 있는 애들 모두 뽑는다.
		List<Integer> list = pickList(nowi, nowj, k);

		// 해당 칸으로 이동하는데 이동할 때 addLast로 추가함.
		addPiece(list, nexti, nextj, reverse);
	}

	private static void addPiece(List<Integer> list, int nexti, int nextj, boolean reverse) {

		// 해당 칸으로 이동하는데 이동할 때 addLast로 추가함.
		int size = list.size();

		if (reverse) {

			for (int s = 0; s < size; s++) {
				pieces[list.get(s)].row = nexti;
				pieces[list.get(s)].col = nextj;
				map[nexti][nextj].addLast(new Piece(list.get(s)));
			}
		} else {
			for (int s = size - 1; s >= 0; s--) {
				pieces[list.get(s)].row = nexti;
				pieces[list.get(s)].col = nextj;
				map[nexti][nextj].addLast(new Piece(list.get(s)));
			}

		}

	}

	private static List<Integer> pickList(int i, int j, int k) {

		List<Integer> list = new LinkedList<>();

		while (true) {
			Piece cur = map[i][j].pollLast();

			list.add(cur.num);

			if (cur.num == k) {
				return list;
			}

		}

	}

	private static int reverseDir(int dir) {
		// 우선 방향 전환
		switch (dir) {
		case 1:
			return 2;
		case 2:
			return 1;
		case 3:
			return 4;
		default:
			return 3;
		}
	}

	static class Piece {
		int row, col, dir, num;

		public Piece(int num) {
			this.num = num;
		}

		public Piece(int row, int col, int dir) {
			this.row = row;
			this.col = col;
			this.dir = dir;
		}
	}

}