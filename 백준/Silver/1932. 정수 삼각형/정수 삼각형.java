import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] arr;
	static int[][] tmp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][];
		tmp = new int[N][];
		
		for(int i=0; i<N; i++) {
			arr[i] = new int[i+1];
			tmp[i] = new int[i+1];
			
			st = new StringTokenizer(br.readLine());
			
			
			for(int j=0; j<i+1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(i==N-1) {
					tmp[i][j] = arr[i][j];
				}
			}
			
		}
		
		int ans = dfs(0, 0, 0);
		
		System.out.println(ans);
	}

	private static int dfs(int nowi, int nowj, int depth) {

		
		if(depth==N-1) {
			return arr[nowi][nowj];
		}
		
		if(tmp[nowi][nowj] == 0) {
			tmp[nowi][nowj] = arr[nowi][nowj] + Math.max(dfs(nowi+1, nowj, depth+1), dfs(nowi+1, nowj+1, depth+1));
		}
		
		return tmp[nowi][nowj];
	}

}