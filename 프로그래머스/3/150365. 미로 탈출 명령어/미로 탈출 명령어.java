import java.io.*;
import java.util.*;

class Solution {

	static int N, M, X, Y, R, C, K;
    static StringBuilder sb;
	static boolean check;
	static int[] di = { 1, 0, 0, -1 };
	static int[] dj = { 0, -1, 1, 0 };
	static String[] dir = {"d", "l", "r", "u"};
	static String answer;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        answer = "impossible";
        sb = new StringBuilder();

		N = n;
		M = m;
		R = r;
		C = c;
		X = x;
		Y = y;
        K = k;

		check = false;
		dfs(x, y, 0);

		return answer;
    }

	private static int checkDistance(int nowi, int nowj) {
		return (int)Math.abs(nowi - R) + (int)Math.abs(nowj - C);
	}

	private static void dfs(int nowi, int nowj, int dis) {

		if (!check) {
			int checkDistanceResult = checkDistance(nowi, nowj);

			if (K - dis - checkDistanceResult < 0 || (K - dis - checkDistanceResult) % 2 == 1)
				return;
			if (dis == K) {
				if (nowi == R && nowj == C) {
					answer = sb.toString();
					check = true;
				}
				return;
			}

			for (int d = 0; d < 4; d++) {
				int nexti = nowi + di[d];
				int nextj = nowj + dj[d];

				if (nexti < 1 || nexti > N || nextj < 1 || nextj > M)
					continue;

				sb.append(dir[d]);
				dfs(nexti, nextj, dis + 1);
				sb.delete(dis, dis + 1);
			}

		}
	}

}