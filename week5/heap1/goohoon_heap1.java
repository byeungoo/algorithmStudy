import java.util.*;

class Solution {
    
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    int answer = 0;
    
    public int solution(int[] scoville, int K) {
        
        for(int i=0;i<scoville.length;i++){
            priorityQueue.add(scoville[i]);
        }
        
        while(true){
            answer++;
            
            int size = priorityQueue.size();
            if(size == 1){
                answer = -1;
                break;
            }
            
            int x = priorityQueue.poll();
            int y = priorityQueue.poll();

            int mixScoville = x + y*2;
            priorityQueue.add(mixScoville);
            
            int frontScoville = priorityQueue.peek();
            if(K <= frontScoville){
                break;
            }
        }
        
        return answer;
    }
}