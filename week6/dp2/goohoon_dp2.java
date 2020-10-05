class Solution {
    private static int dp[][];

    public static void calculateDp(int[][] triangle, int height){

        dp[0][0] = triangle[0][0];

        for(int i=1;i<height;i++){  //행
            for(int j=0;j<i+1;j++){  //열
                if(j == 0){
                    dp[i][j] = dp[i-1][0] + triangle[i][j];
                } else if(j == i){
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                } else{
                    dp[i][j] = Math.max(dp[i-1][j-1] , dp[i-1][j]) + triangle[i][j];
                }
            }
        }

    }

    public static int solution(int[][] triangle) {

        //dp 배열 초기화
        int height = triangle.length;
        dp = new int[height][height];

        //dp 계산
        calculateDp(triangle, height);

        //정답
        int answer = 0;

        for(int i=0;i<height;i++){
            if(dp[height-1][i]>answer){
                answer = dp[height-1][i];
            }
        }

        return answer;
    }
}