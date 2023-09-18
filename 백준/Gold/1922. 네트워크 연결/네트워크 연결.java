import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

			int N = Integer.parseInt(br.readLine()); // 정점 갯수
			int M = Integer.parseInt(br.readLine()); // 간선 갯수
			
			LinkedList<Edge>[] adjList = new LinkedList[N+1];
			
			for(int i=1; i<=N; i++) {
				adjList[i] = new LinkedList<>();
			}
			int from =0;
			int to = 0;
			int weight = 0;
			for(int i=1; i<=M; i++) { 
				StringTokenizer st = new StringTokenizer(br.readLine());
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				weight = Integer.parseInt(st.nextToken());
				
				adjList[from].add(new Edge(weight, to));
				adjList[to].add(new Edge(weight, from));
			} // end input
			
			
			
			boolean[] visited = new boolean[N+1];
			int result = 0; 
			
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			pq.add(new Edge(0, from)); 
			
			int vCnt = 0;
			
			while(!pq.isEmpty()) {
				Edge minEdge = pq.poll();
				
				if(visited[minEdge.num]) 
					continue; 
				
				result += minEdge.weight; 
				visited[minEdge.num] = true; 
				vCnt++;
				
				if(vCnt == N) 
					break;
				
				for(Edge edge: adjList[minEdge.num]) { 
					if(!visited[edge.num]) {
						pq.add(edge);
					}
				}
			} 
			System.out.println(result);

	}

	static class Edge implements Comparable<Edge> { 
		int weight, num;

		Edge(int w, int n) {
			weight = w;
			num = n;
		}

		@Override
		public int compareTo(Edge o) {
			if(this.weight > o.weight)
				return +1;
			else if(this.weight < o.weight)
				return -1;
			return 0;
		}
	}
}