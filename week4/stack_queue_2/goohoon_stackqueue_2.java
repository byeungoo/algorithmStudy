import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        List<Integer> answerList = new ArrayList();
        Queue<Integer> workQueue = initWorkQueue(progresses);
        int size = progresses.length;
        
        int start = 0;
        while(!workQueue.isEmpty()){
            
            int completedNum = 0;
            
            Integer firstNum = workQueue.peek();
            int remainDay = getFirstRemainDay(firstNum, speeds[start]);
            
            for(int curIndex=start;curIndex<size;curIndex++){
                Integer curProgress = workQueue.poll();
                curProgress += speeds[curIndex]*remainDay;
                workQueue.offer(curProgress);
            }
            
            for(int curIndex=start;curIndex<size;curIndex++){
                Integer curProgress = workQueue.peek();
                if(curProgress>=100){
                    workQueue.poll();
                    start += 1;
                    completedNum += 1;
                } else
                    break;
            }
            
            if(completedNum!=0)
                answerList.add(completedNum);
        }
        
        int[] answer = getAnswerArray(answerList);

        return answer;
    }
    
    public Queue<Integer> initWorkQueue(int[] progresses){
        Queue<Integer> workQueue = new LinkedList();
        for(int i=0;i<progresses.length;i++){
            workQueue.offer(progresses[i]);
        }
        
        return workQueue;
    }
    
    public int[] getAnswerArray(List<Integer> answerList){
        int[] answer = new int[answerList.size()];
                for(int i=0;i<answerList.size();i++){
            answer[i] = answerList.get(i);
        }
        return answer;
    }
    
    public int getFirstRemainDay(Integer firstNum, int speed){
        int remainDay = (int)Math.ceil((double)(100-firstNum)/speed);
        return remainDay;
    }
    
}