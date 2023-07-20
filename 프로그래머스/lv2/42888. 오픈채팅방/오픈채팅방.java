import java.util.*;
import java.io.*;

class Solution {
    public String[] solution(String[] record) {
        
        HashMap<String, String> map = new HashMap<>(); // key : 유저아이디, value : 닉네임 
        
        List<Chat> list = new ArrayList<>();
        String[] answer = new String[record.length];
        
        for(int i=0; i<record.length; i++){
            
            StringTokenizer st = new StringTokenizer(record[i]); // 공백을 구분자로 나눠준다.
            
            String word = st.nextToken(); // 명령어
            String id = st.nextToken(); // 유저 아이디
            
            if(!word.equals("Leave")){
                
                String name = st.nextToken();
                map.put(id, name);
                
                if(word.equals("Enter")){
                    list.add(new Chat(id, "님이 들어왔습니다."));
                }
                
            }
            
            else { // "Leave"인 경우
                list.add(new Chat(id, "님이 나갔습니다."));
            }
            
            int listSize = list.size();
            
            answer = new String[listSize];
            
        } // end for i
        
        for(int i=0; i<list.size(); i++){
                String ans = map.get(list.get(i).userId) + list.get(i).behavior;
                answer[i] = ans;
        } // end for i
        
        
        return answer;
    }
    
    static class Chat{
        String userId, behavior;
        
        public Chat(String userId, String behavior){
            this.userId = userId;
            this.behavior = behavior;
        }
    }
}