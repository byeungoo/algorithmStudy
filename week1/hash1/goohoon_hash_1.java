import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String , Integer> map = new HashMap<String , Integer>();
        
        for(String partiPerson : participant){
            map.put(partiPerson, map.getOrDefault(partiPerson,0) + 1);
        }
        
        for(String complePerson : completion){
            
            Integer value = map.get(complePerson);
            value -= 1;
            
            if(value == 0){
                map.remove(complePerson);
            } else {
                map.put(complePerson, value);
            }
        }
            
        for ( String key : map.keySet() ) {
            answer = key;
        }

        return answer;
    }
}