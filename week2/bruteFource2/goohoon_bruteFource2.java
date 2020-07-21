import java.util.*;
import java.lang.*;

class Solution {
    
    public static Map<String, String> map;
    
    public void permutation(int numberArr[], boolean visited[], String answer, int depth, int n){

        //base case 정의
        if(n == depth){
            
            if(!"".equals(answer) && !"0".equals(answer) && !"1".equals(answer)){
                if(answer.charAt(0) == '0'){
                    return;
                }                
                map.put(answer, answer);
            }
            
            return;
        }
        
        for(int i=0;i<numberArr.length;i++){
            
            //방문한곳은 안넣어줌
            if(visited[i] == true){
                continue;
            }
            
            visited[i] = true;
            permutation(numberArr, visited, answer + String.valueOf(numberArr[i]), depth+1, n);
            visited[i] = false;
            permutation(numberArr, visited, answer, depth+1, n);
        }   
    }
    
    public boolean isPrime(Integer num){
        boolean flag = true;
        
        for(int i=2;i<num;i++){
            if(num%i == 0){
                flag = false;
                return flag;
            }
        }
        
        return flag;
    }
    
    public int solution(String numbers) {
        int answer = 0;
        map = new HashMap<>();
        
        int len = numbers.length();
        int numberArr[] = new int[len];      
        boolean visited[]= new boolean[len];      
        
        for(int i=0;i<numbers.length();i++){
             numberArr[i] = Integer.parseInt(numbers.charAt(i)+"");
        }
        
        permutation(numberArr, visited, "", 0, len);

        //소수검사
        for ( String key : map.keySet() ) {
            Integer num = Integer.parseInt(key);
            
            if(isPrime(num) == true)
                answer++;
        }
        
        return answer;
    }
}