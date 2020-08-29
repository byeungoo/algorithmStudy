class Solution {
    final int divider = 1000000007;
    int[][] dp = new int[101][101];

    public int solution(int m, int n, int[][] puddles) {
        for(int i=0;i<puddles.length;i++){
            dp[puddles[i][1]][puddles[i][0]] = -1;
        }
        for(int i=1;i<=m;i++){
            if(dp[1][i] == -1) break;
            dp[1][i] = 1;
        }
        for(int i=1;i<=n;i++){
            if(dp[i][1] == -1) break;
            dp[i][1] = 1;
        }

        for(int y=1;y<=n;y++) {
            for (int x=1;x<=m;x++) {
                if(dp[y][x] == -1) dp[y][x] = 0;
                else if(y==1 || x==1) continue;
                else{
                    dp[y][x] = (dp[y - 1][x] + dp[y][x - 1]) % divider;
                }
            }
        }

        return dp[n][m];
    }
}