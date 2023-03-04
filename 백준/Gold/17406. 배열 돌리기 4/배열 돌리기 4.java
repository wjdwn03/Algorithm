import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, K, min;
	static int[][] arr;
	static int[][] Karr;
	static boolean[] isSelected;
	static int[] num;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][M+1];
		Karr = new int[K][3];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				Karr[i][j] = Integer.parseInt(st.nextToken());
			}
		}//end input
		
		isSelected = new boolean[K];
		num = new int[K];
		min = Integer.MAX_VALUE;
		perm(0);
		
		System.out.println(min);
		
		
	}

	private static void perm(int cnt) {

		if(cnt==K) {
			int[][] rArr = deepcopy(arr);
			for(int i=0; i<K; i++) {
				int idx = num[i];
				int startj = Karr[idx][1] - Karr[idx][2];
				int endi = Karr[idx][0] + Karr[idx][2];
				int endj = Karr[idx][1] + Karr[idx][2];
				for(int starti=Karr[idx][0]-Karr[idx][2]; starti<Karr[idx][0]; starti++) {
					rArr = rotate(starti, startj++, endi--, endj--, rArr);
				}
			}
			for(int i=1; i<=N; i++) {
				int sum=0;
				for(int j=1; j<=M; j++) {
					sum += rArr[i][j];
					if(sum>=min) break;
				}
				min = Math.min(min, sum);
			}
			
			return;
		}
		
		for(int i=0; i<K; i++) {
			if(isSelected[i]) continue;
			num[cnt] = i;
			isSelected[i] = true;
			perm(cnt+1);
			isSelected[i] = false;
		}
		
	}

	private static int[][] deepcopy(int[][] arr) {

		int[][] val = new int[N+1][M+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				val[i][j] = arr[i][j];
			}
		}
		
		return val;
	}

	private static int[][] rotate(int starti, int startj, int endi, int endj, int[][] rArr) {

		int tmp = rArr[starti][startj];
		
		for(int j=startj+1; j<=endj; j++) {
			int next = rArr[starti][j];
			rArr[starti][j] = tmp;
			tmp = next;
		}
		for(int i=starti+1; i<=endi; i++) {
			int next = rArr[i][endj];
			rArr[i][endj] = tmp;
			tmp = next;
		}
		for(int j=endj-1; j>=startj; j--) {
			int next = rArr[endi][j];
			rArr[endi][j] = tmp;
			tmp = next;
		}
		for(int i=endi-1; i>=starti; i--) {
			int next = rArr[i][startj];
			rArr[i][startj]=tmp;
			tmp = next;
		}
		
		return rArr;
	}

}
