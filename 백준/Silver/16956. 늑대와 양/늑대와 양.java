import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R, C, ans;
	static char[][] arr;
	static List<Point> wolf;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		ans = 1;

		arr = new char[R][C];
		wolf = new ArrayList<>();
		
		boolean check = true;

		for (int i = 0; i < R; i++) {
			String input = br.readLine();

			for (int j = 0; j < C; j++) {
				arr[i][j] = input.charAt(j);

				if (arr[i][j] == 'W') {
					wolf.add(new Point(i, j));
				}
				
			}
		} // end input
		
		for(int i=0; i<wolf.size(); i++) {
			for(int d=0; d<4; d++) {
				int nexti = wolf.get(i).i + di[d];
				int nextj = wolf.get(i).j + dj[d];
				if(nexti<0 || nexti>=R || nextj<0 || nextj>=C) continue;
				
				if(arr[nexti][nextj]=='.') {
					arr[nexti][nextj] = 'D';
				}
				
				else if(arr[nexti][nextj]=='S') {
					ans=0;
					break;
				}
			}
			if(ans==0) break;
		}
        
		sb.append(ans).append("\n");

		if (ans == 1) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					sb.append(arr[i][j]);
				}
				sb.append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}

	static class Point {
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
