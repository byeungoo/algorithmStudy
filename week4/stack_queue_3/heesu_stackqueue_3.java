import java.util.LinkedList;
import java.util.Queue;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        int[] truck_times = new int[truck_weights.length];
        int curIdx = 0;

        while(true){
            int curWeight = 0;

            //현재 올라와있는 트럭의 무게 총합
            for(int i=0;i<curIdx;i++){
                if(truck_times[i] < bridge_length) {
                    curWeight += truck_weights[i];
                }
            }

            // 현재 올라와있는 트럭 무게 합 + 새로운 트럭 무게 체크
            if(curWeight + truck_weights[curIdx] <= weight){
                q.offer(truck_weights[curIdx]);
                curIdx++;
            }

            // 모든 트럭이 다 올라와있는 경우이므로 제일 마지막에 올라온 트럭이 다리를 건너는 시점만 계산하면 된다.
            if(curIdx == truck_weights.length){
                answer += bridge_length;
                break;
            }

            // 시간 업데이트
            for(int i=0;i<curIdx;i++){
                if(truck_times[i] <= bridge_length) {
                    truck_times[i]++;
                    if (truck_times[i] > bridge_length) {
                        q.poll();
                    }
                }
            }

            answer++;
        }

        return answer +1;
    }
}