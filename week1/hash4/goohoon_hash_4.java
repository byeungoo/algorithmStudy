import java.util.*;
import java.lang.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
      
        Map<String,Integer> resultMap = new HashMap<>();
        Map<Integer, String> playListMap = new HashMap<>();
        
        int len = genres.length;
        for(int i=0;i<len;i++){
            resultMap.put(genres[i], resultMap.getOrDefault(genres[i], 0) + plays[i]);
            playListMap.put(plays[i], genres[i]);
        }
        
        List<String> keySetList = new ArrayList<>(resultMap.keySet());

		Collections.sort(keySetList, (o1, o2) -> (resultMap.get(o2).compareTo(resultMap.get(o1))));

        List<Integer> resultList = new ArrayList<>();

        for(String k : keySetList){

            int[] max = {-1, -1};
            int[] indexs = {-1, -1};
            for(int i=0;i<len;i++){
                
                if(k.equals(playListMap.get(plays[i]))){
                    if(max[0]<plays[i]){
                        indexs[1] = indexs[0];
                        indexs[0] = i;
                        max[1] = max[0];
                        max[0] = plays[i];
                    } else if(max[0]>plays[i] && plays[i] > max[1]){
                        indexs[1] = i;
                        max[1] = plays[i];
                    } else if(max[0] == plays[i]){
                        indexs[1] = i;
                        max[1] = plays[i];
                    }
                }
            }
            resultList.add(indexs[0]);
            if(indexs[1] != -1)
                resultList.add(indexs[1]);
        }
        
        int resultLen = resultList.size();
        int[] answer = new int[resultLen];
        
        for(int i=0;i<resultLen;i++){
            answer[i] = resultList.get(i);
        }

        System.out.println(resultList.toString());
        
        return answer;
    }
}