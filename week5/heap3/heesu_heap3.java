import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public int[] solution(String[] operations) {
        int[] answer = {};

        int max=-999999, min=999999;

        for(int i=0;i<operations.length;i++){
            String ops = operations[i].split(" ")[0];
            String val = operations[i].split(" ")[1];

            if("I".equals(ops)){
                pq.offer(Integer.parseInt(val));

            }else if("D".equals(ops)){
                if("1".equals(val)){
                    deleteLast();
                }else if("-1".equals(val)){
                    pq.poll();
                }
            }
        }
        while(!pq.isEmpty()){
            int v = pq.poll();
            if(max < v) max = v;
            if(min > v) min = v;
        }
        if(max == -999999) max = 0;
        if(min == 999999) min = 0;

        answer = new int[]{max,min};
        return answer;
    }

    public void deleteLast(){
        PriorityQueue<Integer> tmp = new PriorityQueue<>();

        while(pq.size() > 1){
            tmp.offer(pq.poll());
        }
        pq = tmp;
    }
}