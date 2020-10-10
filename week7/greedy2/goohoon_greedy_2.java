import java.util.*;

class Solution {
    public String solution(String number, int k) {

        StringBuilder sb= new StringBuilder(number);
        int idx = 0;
        
        for(int j=0;j<k;j++){
            int len = sb.length(); 
            idx = len -1;
            
            for(int i=0;i<len-1;i++){
                if(sb.charAt(i)<sb.charAt(i+1)){
                    idx=i;
                    break;
                }
            }
            
             sb.deleteCharAt(idx);
        }
        
        return sb.toString();
    }
}