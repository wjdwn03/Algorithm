import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int answerLen = commands.length;
		int[] answer = new int[answerLen];
		
		for(int i=0; i<answerLen; i++) {
			int[] part = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
			int k = commands[i][2]-1;
			Arrays.sort(part);
			answer[i] = part[k];
		}
        return answer;
    }
}