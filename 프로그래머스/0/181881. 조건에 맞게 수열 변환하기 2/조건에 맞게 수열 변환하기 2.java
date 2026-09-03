import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int len = arr.length;
        int[] beforeArr = arr.clone();
        boolean isSame = false;
        int sameCnt = 0;
        
        while(!isSame){
            
            sameCnt = 0;
            answer++;
            
            // 계산
            for(int i=0; i<len; i++){
                
                if(arr[i] >= 50 && arr[i]%2 == 0){
                    arr[i] = arr[i] / 2;
                }else if(arr[i] < 50 && arr[i] % 2 == 1){
                    arr[i] = arr[i] * 2 + 1;
                }
                
                if(arr[i] == beforeArr[i]){
                    sameCnt++;
                }
            } // end for
            
            beforeArr = arr.clone();
            
            // 검증
            if(sameCnt == len){
                isSame = true;
                answer--;
            }
            
        } // end while
        
        
        return answer;
    }
}