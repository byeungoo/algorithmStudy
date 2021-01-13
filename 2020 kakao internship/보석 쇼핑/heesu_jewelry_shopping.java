import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.lang.Math.abs;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        int answerLen = Integer.MAX_VALUE;
        answer[0] = Integer.MAX_VALUE;


        HashMap<String, List<Integer>> gemMap = new HashMap<>();
        /*
        각 보석 별 idx 셋팅
        map요소 별 greedy
         */
        for(int i=0;i<gems.length;i++){
            List<Integer> tmpList = gemMap.getOrDefault(gems[i], new ArrayList<Integer>());
            tmpList.add(i+1);
            gemMap.put(gems[i], tmpList);
        }

        String startKey = gems[0];
        int strtIdx;
        int endIdx;
        int prevIdx = 0;
        for(Integer i : gemMap.get(startKey)) {
            prevIdx = i.intValue();
            strtIdx = endIdx = prevIdx; // 처음엔 시작값으로 동일하게 셋팅

            for (String key : gemMap.keySet()) {
                if(startKey == key) continue;

                int tmpMin = Integer.MAX_VALUE;
                int minDistIdx=-1;

                for(Integer curIdx : gemMap.get(key)){
                    if(abs(prevIdx - curIdx) < tmpMin){
                        tmpMin = abs(prevIdx - curIdx);
                        minDistIdx = curIdx;
                        //todo strtIDx 최소 확인이 필요?
                    }
                }

                if(minDistIdx < strtIdx) strtIdx = minDistIdx;
                if(minDistIdx > endIdx) endIdx = minDistIdx;
            }

            if(endIdx - strtIdx +1 < answerLen){
                answerLen = endIdx - strtIdx +1;
                answer[0] = strtIdx;
                answer[1] = endIdx;
            }else if(endIdx - strtIdx +1 == answerLen){
                if(strtIdx < answer[0]){
                    answerLen = endIdx - strtIdx +1;
                    answer[0] = strtIdx;
                    answer[1] = endIdx;
                }
            }
        }

        return answer;
    }
}