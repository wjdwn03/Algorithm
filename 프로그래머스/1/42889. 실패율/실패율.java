import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int cnt = stages.length; // 총 사용자 수
        int[] unClearedCnt = new int[N+1]; // 아직 클리어하지 못한 사용자 수
        
        // 각 스테이지 별 클리어하지 못한 사용자 수 입력
        for(int i=0; i<cnt; i++){
            if(stages[i] == N+1)
                continue;
            unClearedCnt[stages[i]]++;
        }
        
        Queue<Game> pq = new PriorityQueue<>();
        
        for(int i=1; i<=N; i++){
            
            double fail = 0;
            
            if(cnt != 0){
                fail = (double)unClearedCnt[i] / cnt; // 실패율 계산    
            }
            
            cnt -= unClearedCnt[i];
            pq.offer(new Game(i, fail));
        }
        
        int idx = 0;
        
        while(!pq.isEmpty()){
            Game cur = pq.poll();
            answer[idx++] = cur.stage;
        }
        
        return answer;
    }
}

class Game implements Comparable<Game>{
    double fail;
    int stage;
    
    public Game(int stage, double fail){
        this.stage = stage;
        this.fail = fail;
    }
    
    @Override
    public int compareTo(Game o){
        if(o.fail == this.fail){
            return Integer.compare(this.stage, o.stage);
        }
        return Double.compare(o.fail, this.fail);
    }
}