import java.util.*;

class Solution {
    
    private int[] person;
    
    public void greedy(int n, int[] lost, int[] reserve){
        for(int i=1;i<=n;i++){
            if(person[i] == 0 && person[i-1] == 2){
                person[i-1] = 1;
                person[i] = 1;
            } else if(person[i] == 0 && person[i+1] == 2){
                person[i+1] = 1;
                person[i] = 1;
            }
        }
    }
    
    public int solution(int n, int[] lost, int[] reserve) {
                
        int answer = 0;
        person = new int[n+2];
        
        for(int i=1;i<=n;i++){
            person[i] = 1;
        }      
        
        for(int i=0;i<lost.length;i++){
            person[lost[i]] = 0;
        }
        
        for(int i=0;i<reserve.length;i++){
            person[reserve[i]] += 1;
        }
        
        greedy(n, lost, reserve);
        
        for(int i=1;i<=n;i++){
            if(person[i]>=1)
                answer+=1;
        }         

        return answer;
    }
}