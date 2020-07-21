import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int idx = 0;
        int[] answer = new int[commands.length];
        
        for(int[] command : commands){
            
            int start = command[0];
            int end   = command[1];
            int k     = command[2];
            
            List<Integer> list = new ArrayList<Integer>();
            
            for(int i=start-1;i<end;i++){
                list.add(array[i]);
            }
            
            Collections.sort(list);
            
            answer[idx] = list.get(k-1);
            idx++;   
        }
        
        return answer;
    }
}