import java.util.*;

class Solution {

    public int solution(int n, int[][] results) {
        int answer = 0;

        int len = results.length;
        boolean[][] graph = new boolean[n+1][n+1];

        for(int[] p : results){
            graph[p[0]][p[1]] = true;
        }

        //플로이드 와샬 알고리즘
        for(int k=1;k<=n;k++){      //거쳐가는 노드
            for(int i=1;i<=n;i++){  //출발 노드
                for(int j=1;j<=n;j++){  //도착 노드
                    if(graph[i][k] && graph[k][j] == true)
                        graph[i][j] = true;
                }
            }
        }

        //순위를 확실히 알 수 있는 사람 구함
        for(int i=1;i<=n;i++){
            int count = 0;
            for(int j=1;j<=n;j++){  //i ~ j 까지 승패의 or 조건이 true이면 둘이 대결 했을 때 결과를 알 수 있음
                if(graph[i][j] || graph[j][i])
                    count++;
            }

            if(count == n-1)  //자기 자신이랑 싸우는 경우 제외하니까 n-1
                answer++;
        }

        return answer;
    }
}