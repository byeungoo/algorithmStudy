public class Solution {

    int[][] map;
    int[][] newMap;
    boolean[] visit;
    int answer = 0;

    public boolean isAllVisit(){
        boolean flag = true;
        for(int i=0;i<visit.length;i++){
            if(visit[i] == false) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public void selectBridge(int n){
        int len = visit.length;
        int cx = 0;
        int cy = 0;
        int min = 99999999;

        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(visit[i] == true && visit[j] == false && map[i][j] <= min && map[i][j] != 0 && newMap[i][j] == 0){
                    min = map[i][j];
                    cx = i;
                    cy = j;
                }
            }
        }

        newMap[cx][cy] = min;
        visit[cy] = true;
        answer += min;
    }

    public int solution(int n, int[][] costs) {

        int len = n;
        map = new int[n][n];
        newMap = new int[n][n];
        visit = new boolean[n];

        //초기화
        for(int i=0; i<costs.length;i++){
            int s = costs[i][0];
            int e = costs[i][1];
            map[s][e] = costs[i][2];
            map[e][s] = costs[i][2];
        }

        //초기 노드 선택
        visit[0] = true;

        while(!isAllVisit()){
            selectBridge(n);
        }

        return answer;
    }

}