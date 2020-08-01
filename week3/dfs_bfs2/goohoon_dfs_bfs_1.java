import java.util.*;

class Solution {
    
    public void dfs(int[][] computers, boolean visited[], int n){
        visited[n] = true;
        
        for(int i=0;i<computers.length;i++){
            if(visited[i] == false && computers[n][i] == 1){
                dfs(computers, visited, i);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        
        int answer = 0;
        
        //visited 배열 초기화
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            visited[i] = false;
        }        

        //dfs
        for(int i=0;i<n;i++){
            if(visited[i] == false){
                dfs(computers, visited, i);
                answer++;
            }
        }
        
        return answer;
    }
}