import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion){
        String answer = "";
        int psize = participant.length;
        HashMap<String, Integer> mapObj = new HashMap<>();

        //initial setting
        for(int i=0;i<psize;i++){

            if(mapObj.get(participant[i]) != null) {
                int curVal = mapObj.get(participant[i]);
                mapObj.replace(participant[i], curVal + 1);
            }else{
                mapObj.put(participant[i], 1);
            }
        }

        for(int i=0;i<psize-1;i++){
            int curVal = mapObj.get(completion[i]);
            mapObj.replace(completion[i], curVal-1);
        }

        for( String key : mapObj.keySet() ){
            if(mapObj.get(key) > 0){
                answer = key;
                break;
            }
        }

        return answer;
    }
}