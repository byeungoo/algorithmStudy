import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Integer> mapObj = new HashMap<>();

        Arrays.sort(phone_book);

        for(String num : phone_book) {
            int numLen = num.length();

            for (int i = 0; i < numLen; i++) {
                String key = num.substring(0, i+1);
                mapObj.put(key, mapObj.getOrDefault(key, 0) + 1);
            }
        }
        for( String key : phone_book ){
            if(mapObj.get(key) > 1){
                answer = false;
                break;
            }
        }
        return answer;
    }
}
