import java.io.*;
import java.util.*;

class Point{
    int x, y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    
    static int N, M, nightX, nightY;
    static int[][] arr;
    static int[] di = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dj = {-1, 1, -2, 2, -2, 2, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N+1][N+1];
     
        st = new StringTokenizer(br.readLine());
        nightX = Integer.parseInt(st.nextToken());
        nightY = Integer.parseInt(st.nextToken());
        
        
        bfs();
        
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            sb.append(arr[x][y]).append(" ");
        }
        
        System.out.println(sb.toString());
        
    }
    
    private static void bfs(){
        Queue<Point> queue = new ArrayDeque<>();
        
        queue.offer(new Point(nightX, nightY));
        
        while(!queue.isEmpty()){
            Point cur = queue.poll();
            
            for(int d=0; d<8; d++){
                int nexti = cur.x + di[d];
                int nextj = cur.y + dj[d];
                
                if(nexti<=0 || nexti > N || nextj <= 0 || nextj > N || arr[nexti][nextj] != 0)
                    continue;
                arr[nexti][nextj] = arr[cur.x][cur.y] + 1;
                queue.offer(new Point(nexti, nextj));
                
            }
        }
    }

}