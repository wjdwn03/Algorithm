import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		int mokfive = num/5;
		int mokthree = 0;
		
		while(mokfive >= 0) {
			if ( (num - (mokfive*5)) % 3 == 0){
				mokthree = (num - (mokfive*5)) / 3;
				break;
			}
			else
				mokfive--;
		}
		
		System.out.println(mokfive + mokthree);

	}

}