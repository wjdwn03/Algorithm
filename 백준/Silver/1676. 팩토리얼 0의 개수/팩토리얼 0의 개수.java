import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// N이 500까지 가능하므로 long의 범위를 넘어서기 때문에 무한대의 범위를 가진 BigInteger를 사용
		BigInteger factorial = BigInteger.ONE; // 1
		
		for(int i=N; i>0; i--) {
			factorial = factorial.multiply(BigInteger.valueOf(i)); // 곱셈
		}
		
		String num = factorial.toString();
		int cnt = 0;
		
		for(int i=num.length()-1; i>=0; i--) {
			if(num.charAt(i)=='0') {
				cnt++;
			}
			else {
				break;
			}
		}
		
		System.out.println(cnt);
		
	}

}