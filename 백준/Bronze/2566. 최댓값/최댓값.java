import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] arr = new int[10][10];
		
		int max = -1;
		int maxI = 0, maxJ = 0;
		
		for(int i=1; i<10; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<10; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(max<arr[i][j]) {
					max = arr[i][j];
					maxI = i;
					maxJ = j;
				}
			}
		}
		
		System.out.println(max);
		System.out.println(maxI + " " + maxJ);
		
		
	}

}