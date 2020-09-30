class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] map = new int[n][m]; 
        
        int pdLen = puddles.length;
        
        for( int i = 0; i<pdLen ; i++) {
            int[] tmp = puddles[i];
            map[tmp[1]-1][tmp[0]-1] = -1;
        }
        
        map[0][0] = 1;
        for(int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                
                if(map[i][j] == -1) {
                    map[i][j] = 0;
                    continue;
                }
                
                if( i > 0 ) {
                    map[i][j] += map[i-1][j]%1000000007;
                }
                if (j>0) {
                    map[i][j] += map[i][j-1]%1000000007;
                }
                
            }
                
        }
        
        answer = map[n-1][m-1] % 1000000007;
        
        return answer;
    }
}