import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        int answerLen = Integer.MAX_VALUE;
        answer[0] = Integer.MAX_VALUE;

        // 전체 gems 체크용
        HashSet<String> gemSet = new HashSet<>(Arrays.asList(gems));

        // 각 구간별 보석 수
        HashMap<String, Integer> gemMap = new HashMap<>();

        int strtIdx = 0;
        int endIdx = 0;

        while(endIdx <= gems.length && strtIdx < gems.length){

            if(gemMap.size() == gemSet.size()){
                // 모든 보석 선택완료 시, strt증가 (최소 보석 수를 구하기 위해)
                strtIdx++;

                // answer 구하기
                if(endIdx - strtIdx + 1 < answerLen || (endIdx - strtIdx + 1 == answerLen && answer[0] > strtIdx)){
                    answerLen = endIdx - strtIdx + 1;
                    answer[0] = strtIdx;
                    answer[1] = endIdx;
                }

                int curVal = gemMap.get(gems[strtIdx-1]);
                if(curVal-1 > 0) {
                    gemMap.put(gems[strtIdx-1], curVal - 1);
                }else{
                    gemMap.remove(gems[strtIdx-1]);
                }
            }
            else{
                if( endIdx == gems.length){
                    strtIdx++;
                }else {
                    gemMap.put(gems[endIdx], gemMap.getOrDefault(gems[endIdx], 0) + 1);
                    endIdx++;
                }
            }
        }

        return answer;
    }
}