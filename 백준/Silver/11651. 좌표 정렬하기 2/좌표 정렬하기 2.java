import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Point> queue = new PriorityQueue<>();
		
		
		for(int n = 0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			queue.add(new Point(x, y));
		}
		
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			
			sb.append(cur.x).append(" ").append(cur.y).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	static class Point implements Comparable<Point>{
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Point o) {
			if(this.y == o.y) {
				return this.x - o.x;
			}
			return this.y - o.y;
		}
	}

}