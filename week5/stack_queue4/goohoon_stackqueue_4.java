import java.util.LinkedList;

class Solution {
    public int solution(int[] priorities, int location) {
       int answer = 0;

        LinkedList<PrintObj> queue = new LinkedList<PrintObj>();

        int size = priorities.length;

        for(int i=0;i<size;i++){
            PrintObj curObj = new PrintObj(priorities[i], i);
            queue.add(curObj);
        }

        while(true){

            PrintObj frontObj = queue.remove();
            int frontPriority = frontObj.getPriority();
            int frontLocation = frontObj.getLocation();

            boolean isMax = true;

            int curSize = queue.size();

            for(int i=0;i<curSize;i++){
                PrintObj curObj = queue.get(i);

                if(curObj.getPriority() > frontPriority){
                    isMax = false;
                    break;
                }

            }

            if(isMax == false){
                queue.add(frontObj);
            } else if(isMax == true && frontLocation != location){
                answer++;
            } else if(isMax == true && frontLocation == location){
                answer++;
                break;
            }
        }


        return answer;
    }
}

class PrintObj{
    
    PrintObj(int priority, int location){
        this.priority  = priority;
        this.location  = location;
    }
    
    private int priority;
    private int location;
    
    public int getPriority(){
        return this.priority;
    }
    
    public int getLocation(){
        return this.location;
    }
    
}