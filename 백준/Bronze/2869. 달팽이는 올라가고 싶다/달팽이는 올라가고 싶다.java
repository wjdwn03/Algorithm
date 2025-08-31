import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		int day = 0;
        if(v == a){
            day = 1;
        }else{
		    if((v-a) >= (a-b)){
                day = (v-a)/(a-b) + 1;
            
                if((v-a)%(a-b)!= 0) 
                    day++;
            }else{
                day = v/a + 1;
            }
        }

		System.out.println(day);
	}

}