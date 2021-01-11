/*
 * 풀이시간 : 1시간
   점수 : 82.6 (케이스 4개 시간초과)
*/ 

import java.util.*;

class Solution {

    static int answer = 2147483647;
    static int size = 0;
    static int[][] next = { {0,1}, {1,0}, {-1,0}, {0, -1} };

    public int solution(int[][] board) {
        size = board.length;
        int[][] boardArr = new int[size+2][size+2];
        initData(board, boardArr);
        boardArr[1][1] = 1;
        bfs(boardArr, 1, 1, 0, null);
        return answer;
    }

    private void bfs(int[][] boardArr, int x, int y, int cost, String dir){

        //base case
        if(x == size && y == size){
            answer = answer > cost ? cost : answer;
            return;
        } else if(cost>answer){
            return;
        }

        for(int i=0;i<4;i++){
            int nx = x + next[i][0];
            int ny = y + next[i][1];
            if(boardArr[nx][ny] == 0){
                String nextDir = "";

                if(i == 0)
                    nextDir = "h";
                else if(i == 1)
                    nextDir = "v";
                else if(i == 2)
                    nextDir = "v";
                else if(i == 3)
                    nextDir = "h";

                boardArr[nx][ny] = 1;
                bfs(boardArr, nx, ny,  getCost(dir, nextDir, cost), nextDir);
                boardArr[nx][ny] = 0;
            }
        }
    }
    private int getCost(String curDir, String nextDir, int cost){

        if(curDir == null){
            cost += 100;
        } else if(curDir.equals(nextDir)){
            cost += 100;
        } else if(!curDir.equals(nextDir)){
            cost += 500 + 100;
        }

        return cost;
    }

    private void initData(int[][] board, int[][] boardArr) {
        int len = boardArr.length;
        for(int i=0;i<len;i++) {
            Arrays.fill(boardArr[i], 1);
        }
        for(int i=1;i<len-1;i++){
            for(int j=1;j<boardArr.length-1;j++){
                boardArr[i][j] = board[i-1][j-1];
            }
        }
    }

}