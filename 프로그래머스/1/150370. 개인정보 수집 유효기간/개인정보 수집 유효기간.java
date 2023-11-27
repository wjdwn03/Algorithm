import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        List<Integer> list = new ArrayList<>();
        int termsLen = terms.length;
        int privaciesLen = privacies.length;
        
        String[] todaySplit = today.split("\\.");
        int todayYear = Integer.parseInt(todaySplit[0]);
        int todayMonth = Integer.parseInt(todaySplit[1]);
        int todayDay = Integer.parseInt(todaySplit[2]);
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<termsLen; i++){
            String[] termsSplit = terms[i].split(" ");
            map.put(termsSplit[0], Integer.parseInt(termsSplit[1]));
        }
        
        for(int i=0; i<privaciesLen; i++){
            String[] privaciesSplit = privacies[i].split(" ");
            String[] dateSplit = privaciesSplit[0].split("\\.");
            
            int year = Integer.parseInt(dateSplit[0]);
            int month = Integer.parseInt(dateSplit[1]);
            int day = Integer.parseInt(dateSplit[2]);
            
            int termMonth = map.get(privaciesSplit[1]);
            
            month += termMonth;
            
            if(month % 12 == 0){
                year += month / 12 - 1;
                
            }
            else{
                year += month / 12;
            }
            
            month = month % 12 == 0 ? 12 : month % 12;
            
            if(todayYear < year)
                continue;
            else if(todayYear == year){
                
                if(todayMonth < month) continue;
                
                else if(todayMonth == month){
                    if(todayDay >= day){
                        // answer에 추가
                        list.add(i+1);
                    }
                }
                else{
                    // answer에 추가
                    list.add(i+1);
                }
                
            }
            else{
                // answer에 추가
                list.add(i+1);
            }
            
        }
        
        int[] answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}