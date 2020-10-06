class Solution {

    private static int dp[][];

    public static void calculateDp(int m, int n){

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i == 0 && j == 0){
                    dp[i][j] = 0;
                } else if(dp[i][j] == -1){
                    dp[i][j] = 0;
                } else if(i != 0 && j != 0){
                    dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007;
                }
            }
        }
    }

    public static void initDp(int m, int n, int[][] puddles){

        //물웅덩이 초기화
        for(int i=0;i<puddles.length;i++){
            dp[puddles[i][1]-1][puddles[i][0]-1] = -1;
        }

        //0행 초기화
        for(int i=0;i<m;i++){
            if(dp[0][i] != -1)
                dp[0][i] = 1;
            else {
                break;
            }
        }

        //0열 초기화
        for(int i=0;i<n;i++){
            if(dp[i][0] != -1)
                dp[i][0] = 1;
            else {
                break;
            }
        }

    }

    public static int solution(int m, int n, int[][] puddles) {

        dp = new int[n][m];
        initDp(m,n,puddles);

        calculateDp(m,n);

        int answer = dp[n-1][m-1];

        return answer;
    }

    public static void main(String[] args) throws Exception{
        int m = 4;
        int n = 3;
        int[][] puddles = {{2,2}};
        solution(m,n,puddles);
    }
}