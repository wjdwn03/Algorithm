import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        
		int maxI = 0;
		int maxJ = 0;
		int minI = 50;
		int minJ = 50;
		
		for(int i=0; i<wallpaper.length; i++) {
			int size = wallpaper[i].length();
			
			for(int j=0; j<size; j++) {
				if(wallpaper[i].charAt(j)=='#') {
					maxI = Math.max(maxI, i);
					maxJ = Math.max(maxJ, j);
					minI = Math.min(minI, i);
					minJ = Math.min(minJ, j);
				}
			}
		}
		
		int[] answer = {minI, minJ, maxI+1, maxJ+1};
        
        return answer;
    }
}