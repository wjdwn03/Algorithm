import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			arr[i] = i;
		}
		
		int i=0, j=0, cnt=0;
		
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			cnt = j;
			int[] copyArr = deepCopy(arr);
			
			for(int idx=i; idx<=j; idx++) {
				arr[idx] = copyArr[cnt--];
			}
		}
		
		for(int idx=1; idx<=N; idx++) {
			System.out.print(arr[idx] + " ");
		}
	}
	
	public static int[] deepCopy(int[] arr) {
		int size = arr.length;
		int[] ans = new int[size];
		
		for(int i=0; i<size; i++) {
			ans[i] = arr[i];
		}
		
		return ans;
	}

}