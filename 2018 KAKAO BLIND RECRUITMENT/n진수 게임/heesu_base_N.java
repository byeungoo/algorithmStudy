class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        int cur = 0;
        int targetLen = m * t + p;
        /*
        10-15 A-F로 변환
        0부터 몇까지 진수변환을 할것인지?
        t <= 1000 (말하는개수)
        m <= 100 (사람수)
        p (차례)
        */

        // 답을 얻을 수 있는 길이까지 String 붙이기
        while(true){
            if(sb.length() >= targetLen){
                break;
            }
            sb.append(this.convert(cur, n));
            cur++;
        }

        for(int i=p-1;i<(m*t+(p-1));i+=m){
            answer.append( sb.charAt(i) );
        }

        return answer.toString();
    }

    public String convert(int cur, int n){
        // cur를 특정 진법으로 변환
        StringBuilder sb = new StringBuilder();

        int exp = 1;
        while(Math.pow(n, exp) <= cur){
            exp++;
        }
        for(int i=exp-1;i>=0;i--){
            int divideNum = (int)Math.pow(n,i);
            sb.append( setNum(cur / divideNum) );
            cur = cur % divideNum;
        }

        return sb.toString();
    }

    private String setNum(int n){
        if(n>=10){
            return String.valueOf((char)('A'+(n-10)));

        }else{
            return String.valueOf(n);
        }
    }
}