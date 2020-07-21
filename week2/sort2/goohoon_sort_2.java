import java.util.*;

public class Solution {
    public String solution(int[] numbers) {
        
        String[] numberArr = new String[numbers.length];
        
        for(int i=0;i<numbers.length;i++){
            numberArr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(numberArr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1+s2).compareTo(s2+s1);
            }
        });
        
        String answer = "";
                
        if (numberArr[0].equals("0")) return "0";

        for(int i=0;i<numberArr.length;i++){
           answer += numberArr[i];
        }   
        
        return answer;
    }
}