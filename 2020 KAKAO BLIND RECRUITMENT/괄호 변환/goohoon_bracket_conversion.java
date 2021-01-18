import java.util.*;


class Solution {
    
    String answer = "";

    public String solution(String p) {
        int balanceIndex = getBalanceIndex(p);
        answer = recursive(p, balanceIndex);
        System.out.println(answer);
        return answer;
    }

    public String recursive(String p, int balanceIndex){

        if(p.length() == 0) {
            return "";
        } else if(isCorrectBracket(p)){
            return p;
        }

        String u = p.substring(0,balanceIndex);
        String v = p.substring(balanceIndex);
        int nextBalanceIndexV = getBalanceIndex(v);

        if(isCorrectBracket(u)){
            return u + recursive(v,nextBalanceIndexV);
        } else{
            return "(" + recursive(v,nextBalanceIndexV) + ")" + reverse(u.substring(1,u.length()-1));
        }
    }

    public int getBalanceIndex(String sub){
        int i;
        int n1 = 0;
        int n2 = 0;
        for(i=0;i<sub.length();i++){
            if(sub.charAt(i) == '(')
                n1++;
            else
                n2++;
            if(n1 == n2)
                return i+1;
        }
        return i;
    }

    public String reverse(String sub){
        StringBuffer sb= new StringBuffer();
        for(int i=0;i<sub.length();i++){
            String w = String.valueOf(sub.charAt(i));
            if("(".equals(w))
                sb.append(")");
            else
                sb.append("(");
        }
        return sb.toString();
    }

    public boolean isCorrectBracket(String w){
        int count = 0;
        for(int i = 0 ; i < w.length(); i++) {
            if(w.charAt(i) == '(') {
                count++;
            }else
                count--;
            if(count < 0)
                return false;
        }
        return count == 0;
    }
    
}