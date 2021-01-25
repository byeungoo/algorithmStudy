import java.util.*;

class Solution {
    
    public String[] solution(String[] record) {


        //1. 유저의 마지막 닉네임 구함
        Map<String, String> userMap = new HashMap<>();
        for (String user : record){
            String[] s = user.split(" ");
            if(s[0].equals("Enter"))
                userMap.put(s[1], s[2]);
            else if(s[0].equals("Change"))
                userMap.put(s[1], s[2]);
        }

        //2. 메세지 add
        List<String> messages = new ArrayList<>();
        for (String user : record){
            String[] s = user.split(" ");
            if(s[0].equals("Enter")){
                messages.add(userMap.get(s[1])+ "님이 들어왔습니다.");
            } else if(s[0].equals("Leave")) {
                messages.add(userMap.get(s[1])+ "님이 나갔습니다.");
            }
        }
        
        //3. List to Array
        String[] answer = new String[messages.size()];
        for(int i=0;i<messages.size();i++){
            answer[i] = messages.get(i);
        }

        return answer;
    }
    
}