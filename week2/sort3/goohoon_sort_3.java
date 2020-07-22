import java.util.*;

class Solution {
    public int solution(int[] citations) {
        
        int answer = 0;
    
        Arrays.sort(citations);
        int len = citations.length;     

        for (int i = 0; i < len; i++) {
            int h = citations.length - i;
 
            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }

        return answer;
    }
}