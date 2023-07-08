import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		String s = br.readLine();
		int cnt = 0;
		
		int aCnt = 0;
		int bCnt = 0;
		
		boolean check = true; // 폴리오미노로 덮을 수 있는 보드판인지 확인하는 변수

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'X') {
				cnt++;
			} else { // '.'인 경우

				// X의 개수가 홀수개면 무조건 다 채울 수 없다.
				if (cnt % 2 != 0) {
					sb = new StringBuilder();
					sb.append("-1");
					check = false;
					break;
				}

				if (cnt == 0) {
					sb.append(".");
					cnt = 0;
					continue;
				}


				if (cnt < 4) {
					bCnt = cnt / 2;
					
					bFill(bCnt);
				}
				if (cnt >= 4) {
					
					aCnt = cnt / 4;
					bCnt = (cnt % 4) / 2;
					
					aFill(aCnt);
					bFill(bCnt);
				}
				cnt = 0;
				sb.append(".");
			} // end else
		} // end for i
		
		if(sb.length()!=s.length() && check) {
			if(cnt%2 != 0) {
				sb = new StringBuilder();
				sb.append("-1");
			}
			else {
				
				if(cnt<4) {
					bCnt = cnt/2;
					bFill(bCnt);
				}
				else if(cnt>=4) {
					aCnt = cnt/4;
					bCnt = (cnt%4)/2;
					
					aFill(aCnt);
					bFill(bCnt);
				}
			}
		}
		
		System.out.println(sb.toString());
	}

	public static void aFill(int cnt) {
		for(int i=0; i<cnt; i++) {
			sb.append("AAAA");
		}
	}

	public static void bFill(int cnt) {
		
		for(int i=0; i<cnt; i++) {
			sb.append("BB");
		}

	}

}