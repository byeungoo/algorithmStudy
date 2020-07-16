import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        int size = phone_book.length;
        
        for(int i=0;i<size-1;i++){
            
            int curPhoneLen = phone_book[i].length();
            int nextPhoneLen = phone_book[i+1].length();
            
            String nextStr = "";
            
            if(curPhoneLen <= nextPhoneLen){
                 nextStr = phone_book[i+1].substring(0, curPhoneLen);
            }
            
           
            if(nextStr.equals(phone_book[i])){
                answer = false;
                break;
            }
            
        }
        
        return answer;
    }
}