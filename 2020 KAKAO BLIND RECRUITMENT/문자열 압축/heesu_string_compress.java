import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String s) {
        int answer = s.length();

        /*
        str 제한 1000자이기 때문에 각 자르기str 별 다 체크해도 괜찮다.
         -> str.len / 2 까지만 체크하면 됌.
         */

        for(int i=1;i<=s.length()/2+1;i++){
            int strtIdx = 0;
            int compCnt = 0;
            int compStrChngCnt = 1;
            int compStrChngSum = 0;

            String targetStr = s.substring(strtIdx, strtIdx+i);
            strtIdx = strtIdx + i;

            while(strtIdx + i <= s.length()){

                if(targetStr.equals(s.substring(strtIdx, strtIdx + i))){
                    compCnt++; // 압축된 횟수 aaaabb -> 10a2b
                    compStrChngCnt++; //2

                }else{
                    targetStr = s.substring(strtIdx, strtIdx+i);
                    if (compStrChngCnt > 1) {
                        compStrChngSum += (compStrChngCnt + "").length();
                    }
                    compStrChngCnt = 1;
                }
                strtIdx += i;
            }
            if (compStrChngCnt > 1) {
                compStrChngSum += (compStrChngCnt + "").length();
            }

            int tmpAns = s.length() - (compCnt*i) + compStrChngSum;
            if(answer > tmpAns) answer = tmpAns;
        }

        return answer;
    }
}