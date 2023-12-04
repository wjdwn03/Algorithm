import java.util.*;
import java.io.*;

class Solution {
    
    static List<Integer>[] list;
	static boolean[] visit;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        list = new ArrayList[n];
        
        // 초기화
        for(int i=0; i<n; i++) {
        	list[i] = new ArrayList<>();
        }
        
        visit = new boolean[n];
        
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++) {
        		if(i==j || computers[i][j] == 0) continue;
        		
        		list[i].add(j);
        		list[j].add(i);
        	}
        }
        
        for(int i=0; i<n; i++) {
        	if(visit[i]) continue;
        	
        	dfs(i);
        	answer++;
        }
        
        return answer;
    }
    
        public static void dfs(int now) {
    	
    	if(visit[now]) return;
    	
    	visit[now] = true;
    	
    	int size = list[now].size();
    	
    	for(int i=0; i<size; i++) {
    		dfs(list[now].get(i));
    	}
    }
}