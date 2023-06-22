import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static class Node{
		
		int to;
		Node next;
		
		public Node(int to, Node next) {
			this.to = to;
			this.next = next;
		}
	}
	
	static int computer, edge, cnt;
	static Node[] node;
	static boolean[] visit;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		computer = Integer.parseInt(br.readLine());
		edge = Integer.parseInt(br.readLine());
		
		cnt = 0;
		node = new Node[computer+1];
		visit = new boolean[computer+1];
		
		StringTokenizer st;
		
		int from=0, to=0;
		
		for(int i=0; i<edge; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			
			// 꼬리에 넣는게 아니라 헤더쪽에 넣어준다.
			node[from] = new Node(to, node[from]);
			node[to] = new Node(from, node[to]);
		}
		
		dfs(1);
		System.out.println(cnt);
		
	}

	private static void dfs(int cur) {
		
		visit[cur] = true;
		
		// node가 끝까지 다 돌 때까지 반복
		for(Node temp=node[cur]; temp!=null; temp=temp.next) {
			if(!visit[temp.to]) {
				cnt++;
				dfs(temp.to);
			}
		}
		
	}

}