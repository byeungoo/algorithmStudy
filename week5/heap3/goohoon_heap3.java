import java.util.*;

class Solution {
    
    Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    Queue<Integer> minHeap = new PriorityQueue<>();
    
    public int[] solution(String[] operations) {
        
        int len = operations.length;
        int[] answer = new int[2];
        
        for(int i=0;i<len;i++){
            String opers[] = operations[i].split(" ");

            if("I".equals(opers[0])){       
                int num = Integer.parseInt(opers[1]);
                maxHeap.add(num);
                minHeap.add(num);
            } else if(!minHeap.isEmpty()){
              if(opers[1].equals("1")) 
                  deleteElement(minHeap, maxHeap.poll());
              else 
                  deleteElement(maxHeap, minHeap.poll());
            } 
        }

        answer[0] = maxHeap.isEmpty() ? 0 : maxHeap.poll();
        answer[1] = minHeap.isEmpty() ? 0 : minHeap.poll();
        return answer;        
    }
    
   public void deleteElement(Queue<Integer> queue, int num) {
      List<Integer> temp = new ArrayList<>();
      while(!queue.isEmpty()) {
         int extract = queue.poll();
         if(extract == num) break;
         temp.add(extract);
      }
      queue.addAll(temp);
   }

}