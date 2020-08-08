import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        int day = 1;
        int deployCnt = 0;
        boolean[] isDone = new boolean[progresses.length];
        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<progresses.length;i++){
            q.offer(i);
        }

        while(!q.isEmpty()){
            int headIdx = q.peek();
            if( progresses[headIdx] + speeds[headIdx] * day >= 100){
                q.poll();
                deployCnt++;
            }else{
                day++;
                if(deployCnt > 0){
                    answer.add(deployCnt);
                }
                deployCnt = 0;
            }
        }
        if(deployCnt >0) answer.add(deployCnt);

        int[] answerArr = new int[answer.size()];
        for(int i=0;i<answer.size();i++){
            answerArr[i] = answer.get(i);
        }

        return answerArr;
    }
}