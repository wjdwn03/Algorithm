import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {

	static int N;
	static int[] port;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		port = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			port[i] = Integer.parseInt(st.nextToken());
		}

		int[] arr = new int[N+1];
		
		int len = 0;
		int idx = 0;
		
		for(int i=0; i<N; i++) {
			if(port[i]>arr[len]) {
				arr[++len] = port[i];
			}
			else {
				idx = searchIdx(arr, 0, len, port[i]);
				arr[idx] = port[i];
			}
		}

		System.out.println(len);
	}

	private static int searchIdx(int[] arr, int start, int end, int num) {

		int mid = (start+end)/2;
		
		while(start<end) {
			mid = (start+end)/2;
			
			if(arr[mid]<num) {
				start = mid+1;
			}
			else {
				end = mid;
			}
		}
		return end;
	}

}