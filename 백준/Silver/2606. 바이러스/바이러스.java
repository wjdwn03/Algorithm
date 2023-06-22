import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int computer, twin, cnt;
	static List<Integer>[] list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		computer = Integer.parseInt(br.readLine());
		twin = Integer.parseInt(br.readLine());
		cnt = 0;
		list = new ArrayList[computer+1];
		
		StringTokenizer st;
		
		// 리스트 초기화
		for(int i=0; i<=computer; i++) {
			list[i] = new ArrayList<>();
		}
		
		int from=0, to=0;
		
		for(int i=0; i<twin; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(from);
		}// end input
		
		bfs(1);
		
		System.out.println(cnt);
		
		
	}

	private static void bfs(int v) {
		
		Queue<Integer> queue = new ArrayDeque<>();
		
		boolean[] visit = new boolean[computer+1];
		
		queue.offer(v);
		visit[v] = true;
		
		while(!queue.isEmpty()) {
			
			int cur = queue.poll();
			
			// 각 정점에 연결된 정점의 수만큼 반복
			for(int i=0; i<list[cur].size(); i++) {
				
				int now = list[cur].get(i);
				
				if(!visit[now]) {
					queue.offer(now);
					visit[now] = true;
					cnt++;
				}
			}
		}
		
	}

}