import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> pMap = new HashMap<>();
        HashMap<String, ArrayList<Integer>> eMap = new HashMap<>();
        ArrayList<Integer> answerList = new ArrayList<>();
        int[] answer;

        for(int i=0;i<plays.length;i++){
            pMap.put(genres[i], pMap.getOrDefault(genres[i],0) + plays[i]);
            if (eMap.get(genres[i]) == null) {
                eMap.put(genres[i], new ArrayList<>(i) );
            }
            eMap.get(genres[i]).add(i);

        }
        List<String> keyList = new ArrayList<>(pMap.keySet());
        Collections.sort(keyList , (e1, e2) -> (pMap.get(e2).compareTo(pMap.get(e1))) );

        for(String key : keyList) {
            Collections.sort(eMap.get(key), (e1, e2) -> (Integer.valueOf(plays[e2]).compareTo(Integer.valueOf(plays[e1]))));

            for(Integer element : eMap.get(key)){
                if(eMap.get(key).indexOf(element) >= 2) break;
                answerList.add(element);
            }
        }
        answer = new int[answerList.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = answerList.get(i).intValue();
        }

        return answer;
    }
}