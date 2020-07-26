import java.util.*;

class Solution {
    
    private static Map<String, Integer> map; 
    
    public void permutation(boolean[] visited, int depth, String answer){
        
        if(depth == 3){
            if(answer.length() == 3)
                map.put(answer, 0);
            return;
        }
        
        for(int i=1;i<=9;i++){
            
            if(visited[i] == true){
                continue;
            }
            
            visited[i] = true;
            permutation(visited, depth+1,  answer +String.valueOf(i));
            visited[i] = false;
            permutation(visited, depth+1, answer);
        }
    }
    
    public void countAnswer(int[] base){

        for(String key : map.keySet()){
            
            int ball = 0;
            int strike = 0;
            String baseValue = Integer.toString(base[0]);
            
            //스트라이크 검사
            for(int i = 0;i<3;i++){
                if(key.charAt(i) == baseValue.charAt(i)){
                    strike+=1;
                }
            }
            //볼 검사
            for(int i = 0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(i!=j && key.charAt(i) == baseValue.charAt(j)){
                        ball+=1;
                    }
                }
            }
            
            //스트라이크 수, 볼 수 더해줌
            if(strike == base[1] && ball == base[2]){
                map.put(key, map.get(key) + 1);
            }
        }
    }
    
    public int solution(int[][] baseball) {
        int answer = 0;
        
        boolean[] visited = new boolean[10];
        map = new HashMap<>();
        
        permutation(visited, 0, "");
        
        for(int[] base : baseball){
            countAnswer(base);
        }

        int len = baseball.length;
        for(String key : map.keySet()){
            if(len == map.get(key))
                answer++;
        }
        
        return answer;
    }
}