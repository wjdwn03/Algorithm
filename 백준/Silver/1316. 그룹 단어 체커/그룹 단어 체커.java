import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		int[] arr = new int[27];
		
		for(int i=0; i<N; i++) {
			String word = br.readLine();
			arr = new int[27]; // 알파벳 문자 배열 새롭게 갱신
			arr[word.charAt(0)-'a']++; // 첫 문자 일단 카운트업
			char before = word.charAt(0); // 이전 문자 확인용
			boolean check = true; // 그룹 단어인지 확인용
			
			for(int j=1; j<word.length(); j++) {
				
				char now = word.charAt(j);
				
				// 이전 문자와 다른데 0보다 크면 그룹 문자가 아니다.
				if(before!=now && arr[now-'a']>0) {
					check = false;
					before = now; // 이전 문자 갱신
					break;
				}
				
				// 이전 문자와 다른데 0이면 연속해서 나타나는 문자가 최초로 나타는 경우이다.
				else if(before!= now && arr[now-'a']==0) {
					check = true;
					arr[now-'a']++;
				}
				
				// 이전 문자와 같다면 그룹 문자이다.
				else if(before == now) {
					arr[now-'a']++;
				}
				
				before = now; // 이전 문자 갱신
			}
			
			// 그룹 단어로 판별되면 카운트 업
			if(check) {
				cnt++;
			}
					
		} // end for i
		
		System.out.println(cnt);
	}

}