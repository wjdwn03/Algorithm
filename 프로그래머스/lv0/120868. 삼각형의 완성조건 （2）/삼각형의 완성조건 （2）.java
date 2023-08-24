import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] sides) {
    
        int min = 0;
        
        if(sides[0]>sides[1]){
            min = sides[1];
        }
        else{
            min = sides[0];
        }
        int answer = min*2-1;
        return answer;
    }
}