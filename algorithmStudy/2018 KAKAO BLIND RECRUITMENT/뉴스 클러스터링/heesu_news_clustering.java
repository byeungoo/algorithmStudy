class Solution {
    public int solution(String str1, String str2) {
        /*
         - 0,1,2.. 2개씩 끊어서 원소 찾rl
         - 교, 합집합 원소 수 셋팅
         - 소문자, 대문자 동일 취급
         - 특수문자, 숫자포함은 버림 (65 ~ 90)
         - 공집합 존재 시, 0 처리
         - 결과값에 대해서 65536 곱하고 소수점아래 버림
         */

        boolean[] cross = new boolean[str2.length()];
        double crossCnt = 0;
        int answer = 0;

        //1000까지 길이면 e가 999개나오고 2중으로 돌려도 됌
        for(int i=0;i<str1.length()-1;i++){
            String e1 = str1.substring(i, i+2).toUpperCase();
            if(!isRightString(e1)) continue;

            for(int j=0;j<str2.length()-1;j++) {
                if (!cross[j]) {
                    String e2 = str2.substring(j, j+2).toUpperCase();
                    if(!isRightString(e2)) continue;

                    if (e1.equals(e2)) {
                        // 교집합 요소로 체크
                        cross[j] = true;
                        crossCnt++;
                        break; // 하나만 찾으면 break, 다중교집합
                    }
                }
            }
        }
        double sumCnt = str1.length()-1 + str2.length()-1 - wrongStrCnt(str1.toUpperCase()) - wrongStrCnt(str2.toUpperCase()) - crossCnt;
        if(sumCnt == 0) answer = 65536;
        else {
            double tmpAns = crossCnt / sumCnt * 65536;
            answer = (int) (Math.floor(tmpAns));
        }

        return answer;
    }

    boolean isRightString(String s){
        // 길이중에서 ascii 65~90 벗어나면 false
        boolean flag = true;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) < 'A' || s.charAt(i) > 'Z'){
                flag = false;
                break;
            }
        }
        return flag;
    }

    double wrongStrCnt(String s){
        double cnt=0;
        for(int i=0;i<s.length()-1;i++){
            if( (s.charAt(i) < 'A' || s.charAt(i) > 'Z') ||
                    (s.charAt(i+1) < 'A' || s.charAt(i+1) > 'Z')){
                cnt++;
            }
        }
        return cnt;
    }
}