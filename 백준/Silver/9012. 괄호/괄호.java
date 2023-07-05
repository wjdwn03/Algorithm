import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			String ps = br.readLine();
			
			Deque<Character> stack = new ArrayDeque<>();
			
			boolean check = true; // VPS인지 확인하는 변수 
			
			for(int i=0; i<ps.length(); i++) {
				
				// 여는 괄호면 스택에 PUSH 한다.
				if(ps.charAt(i)=='(') {
					stack.push('(');
				} 
				// 닫는 괄호인 경우
				else if(ps.charAt(i)==')'){
					// 스택에서 poll 하는 값이 '('이거나 stack에 값이 0이면 VPS가 아니다. 
					if( stack.size() == 0 || stack.poll()!='(') {
						sb.append("NO").append("\n");
						check = false;
						break;
					}
					
				} // end else
			} // end for i
			
			// 이미 닫는 괄호가 다 나온 상황에서 check가 true인 상황
			if(check) {
				
				// 스택 사이즈가 0이면 VPS이다.
				if(stack.size()==0) {
					sb.append("YES").append("\n");
				} 
				// 스택 사이즈가 0이 아니면 여는 괄호가 남아있다는 말이므로 VPS가 아니다.
				else {
					sb.append("NO").append("\n");
				}
			}
		} // end for t
		
		System.out.println(sb.toString());
	}

}