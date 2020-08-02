class Solution {
    int answer = 0;
    int[] visit = new int[201];

    public int solution(int n, int[][] computers) {
        for(int i=0;i<n;i++){
            if(visit[i] == 0) answer++;
            dfs(i, n, computers);
        }
        return answer;
    }

    public void dfs(int cur, int n, int[][]computers){
        visit[cur] = 1;
        int cnt = 0;
        for(int i=0;i<n;i++){
            if(computers[cur][i] == 1 && cur != i) {
                int next = i;
                if (visit[next] == 0) {
                    dfs(next, n, computers);
                }
            }
        }
    }
}