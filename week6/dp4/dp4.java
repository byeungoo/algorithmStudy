class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int mLen = money.length;
        
        int[] dp = new int[mLen];
        dp[0] = money[0];
        dp[1] = money[0];
        
        int[] dp2 = new int[mLen];
        dp2[0] = 0;
        dp2[1] = money[1];
        
        for(int i = 2; i < mLen; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+money[i]);
            dp2[i] = Math.max(dp2[i-1], dp2[i-2]+money[i]);
        }
        
        answer = Math.max(dp[mLen-2], dp2[mLen-1]);
        
        return answer;
    }
}