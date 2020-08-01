import java.util.*;

import java.util.*;

class Solution {

    class Node{
        int x = 0;
        int y = 0;
    }

    public void bfs( Boolean[][] visited, int[][] computers, int x, int y, int n){

        Queue<Integer> queue = new LinkedList();
        visited[x][y] = true;
        queue.offer(computers[x][y]);

        while(!queue.isEmpty()){
            if(x-1<0 || x+1 == n || y-1<0 || y+1 == n){
                continue;
            }


        }
    }

    public int solution(int n, int[][] computers) {

        int answer = 0;
        Boolean[][] visited = new Boolean[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j] == false){
                    //bfs(visited, computers, i, j, n);
                    answer++;
                }
            }
        }

        return answer;
    }
}