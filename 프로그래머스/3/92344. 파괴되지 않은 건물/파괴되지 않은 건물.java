import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        int N = board.length;
        int M = board[0].length;
        int skillLen = skill.length;
        
        int[][] arr = new int[N+1][M+1];
        
        int[] point = {0, -1, 1};
        
        // 누적합 이용
        for(int s=0; s<skillLen; s++) {
        	arr[skill[s][1]][skill[s][2]] += skill[s][5] * point[skill[s][0]];
        	arr[skill[s][3]+1][skill[s][4]+1] += skill[s][5] * point[skill[s][0]];
        	
        	arr[skill[s][1]][skill[s][4]+1] += skill[s][5]*point[skill[s][0]] * -1;
        	arr[skill[s][3]+1][skill[s][2]] += skill[s][5]*point[skill[s][0]] * -1;
        }
        
        for(int j=0; j<M; j++) {
        	for(int i=1; i<N; i++) {
        		arr[i][j] += arr[i-1][j];
        	}
        }
        
        for(int i=0; i<N; i++) {
        	for(int j=1; j<M; j++) {
        		arr[i][j] += arr[i][j-1];
        	}
        }
        
        
        for(int i=0; i<N; i++) {
        	for(int j=0; j<M; j++) {
        		board[i][j] += arr[i][j];
        		if(board[i][j]>0)
        			answer++;
        	}
        }
        
        return answer;
    }
}