import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String totalString = "";
        int cur = p-1;
        
        for (int i=0;answer.length()<t;i++){
            totalString += changeDecimaNumber(i, n);

            if(totalString.length()<=cur) {
                continue;
            } else{
                answer += totalString.charAt(cur);
                cur += m;
            }
            
        }

        return answer;
    }

    public String changeDecimaNumber(int number, int n){
        if(number < n){
            return getChangeStringNum(number);
        }

        int rest = number%n;
        String stringRest = getChangeStringNum(rest);

        return changeDecimaNumber(number/n, n) + stringRest;
    }

    private String getChangeStringNum(int number) {
        if(number >= 10 && number <=15) {
            return "" + (char) (number+55);
        } else{
            return String.valueOf(number);
        }
    }

}