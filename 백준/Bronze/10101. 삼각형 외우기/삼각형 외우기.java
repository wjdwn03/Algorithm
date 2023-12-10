import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		int sum = 0;
		int[] arr = new int[3];
		
		for(int i=0; i<3; i++) {
			int angle = Integer.parseInt(br.readLine());
			arr[i] = angle;
			
			sum += angle;
			
			if(map.containsKey(angle)) {
				int cnt = map.get(angle);
				map.put(angle, cnt + 1);
			}
			else {
				map.put(angle, 0);
			}
		}
		
		int size = map.size();
		
		if(size == 1 && arr[0] == 60)
			sb.append("Equilateral");
		else if(sum != 180)
			sb.append("Error");
		else if(sum == 180) {
			if(size == 3) {
				sb.append("Scalene");
			}
			else if(size==2) {
				sb.append("Isosceles");
			}
		}
		
		System.out.println(sb.toString());
		
		
	}

}