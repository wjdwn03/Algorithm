import java.util.*;
import java.io.*;

class Solution {
    public String[] solution(String[] record) {
        
        HashMap<String, String> map = new HashMap<>(); // key : 유저아이디, value : 닉네임 
        
        List<Chat> list = new ArrayList<>();
        String[] answer = new String[record.length];
        
        for(int i=0; i<record.length; i++){
            
            String[] input = record[i].split(" "); // 공백을 구분자로 나눠준다.
            
            
            if (!input[0].equals("Leave")) {

				map.put(input[1], input[2]);

				if (input[0].equals("Enter")) {
					list.add(new Chat(input[1], "님이 들어왔습니다."));
				}

			}
            
            else { // "Leave"인 경우
                list.add(new Chat(input[1], "님이 나갔습니다."));
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