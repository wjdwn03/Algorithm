import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String A = br.readLine();
		String B = br.readLine();
		
		int[][] arr = new int[15][16];
		int cnt=0;
		
		for(int i=0; i<8; i++) {
			arr[0][cnt++] = A.charAt(i)-'0';
			arr[0][cnt++] = B.charAt(i)-'0';			
		}
		
		
		for(int i=1; i<15; i++) {
			for(int j=0; j<16-i; j++) {
				arr[i][j] = (arr[i-1][j] + arr[i-1][j+1])%10;
			}
		}
		
		String ans = String.valueOf(arr[14][0]*10).charAt(0) + String.valueOf(arr[14][1]);
		
		System.out.println(ans);
	}

}