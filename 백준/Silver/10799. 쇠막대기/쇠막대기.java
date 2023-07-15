import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		Deque<Point> stack = new ArrayDeque<>();
		
		int stick = 0; // 잘려진 쇠막대 개수
		int laser = 0; // 레이저 개수
		
		for(int i=0; i<input.length(); i++) {
			
			if(input.charAt(i)=='(') {
				stack.push(new Point(i, laser));
			}
			// ')'인 경우
			else {
				// 스택에서 뽑은 값의 위치랑 현재 위치가 1 차이나면 레이저다. 
				if(i - stack.peek().i == 1) {
					stack.poll(); 
					laser++;
				}
				// 그게 아니면 막대기이므로 
				else {
					// "해당 막대기가 맞은 레이저 수 = 현재 레이저 개수 - 막대기 시작 당시 레이저 개수" 이고
					// 잘린 막대기 수는 "해당 막대기가 맞은 레이저 수 + 1"이다.
					stick += laser-stack.poll().cnt + 1;
				}
			}
		} // end for i
		
		System.out.println(stick);
	}
	
	static class Point{
		int i, cnt;
		
		public Point(int i, int cnt) {
			this.i = i; // 막대기가 시작되는 위치
			this.cnt = cnt; // 레이저 개수
		}
	}

}