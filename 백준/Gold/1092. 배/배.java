import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M, min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// crane 입력 시작
		N = Integer.parseInt(br.readLine());
		List<Integer> crane = new ArrayList<>();
		List<Integer> box = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			crane.add(Integer.parseInt(st.nextToken()));
		}
		// crane 입력 끝

		// box 입력 시작
		M = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			box.add(Integer.parseInt(st.nextToken()));
		} // end input

		// 내림차순 정렬
		Collections.sort(crane, Collections.reverseOrder());
		Collections.sort(box, Collections.reverseOrder());
		
		
		min = M;

		if(crane.get(0) < box.get(0)) {
			min = -1;
		}
		else {
			int i =0;
			int time = 0;
			

			while(!box.isEmpty()) {
				
				int boxIdx = 0, craneIdx = 0;
				while (craneIdx < N) {
					
					if(boxIdx==box.size()) {
						break;
					}
					else if(crane.get(craneIdx)>=box.get(boxIdx)) {
						box.remove(boxIdx);
						craneIdx++;
					}
					else {
						boxIdx++;
					}
				}
				
				time++;
				
			}
			
			min = time;
		}


		System.out.println(min);

	}

}