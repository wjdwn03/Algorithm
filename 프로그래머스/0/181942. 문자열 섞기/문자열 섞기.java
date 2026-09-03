import java.io.*;
import java.util.*;

class Solution {
    
    public String solution(String str1, String str2) {
        int len = str1.length();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<len; i++){
            sb.append(str1.charAt(i));
            sb.append(str2.charAt(i));
        }
        
        return sb.toString();
    }
}