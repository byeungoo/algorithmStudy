import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;

        answer = bfs(board);

        return answer;
    }

    public int bfs(int[][] board) {
        Queue<Coord> q = new LinkedList<>();
        int[] moveX = new int[]{1,0,-1,0};
        int[] moveY = new int[]{0,1,0,-1};
        String[] moveStr = new String[]{"V","H","V","H"};
        int[][] cost = new int[board.length][board.length];

        // start setting
        q.offer(new Coord(0, 0, 0, 0, "S"));

        for(int i=0;i<cost.length;i++){
            for(int j=0;j<cost.length;j++){
                cost[i][j] = 999999;
            }
        }
        cost[0][0] = 100;


        while (!q.isEmpty()) {

            // 맨 앞 coord 꺼내서 해당 coord 에서 갈 수 있는 경로 q에 다시 push
            Coord cur = q.poll();
            String prevMove = cur.moveStr;
            int prevCost = cur.cost;
            int prevDir = cur.direction;

            for (int i = 0; i < 4; i++) {

                // 체크1. 좌우 체크
                if (cur.x + moveX[i] > board.length - 1 || cur.y + moveY[i] > board.length - 1
                        || cur.x + moveX[i] < 0 || cur.y + moveY[i] < 0) {
                    continue;
                }

                // 체크2. 되돌아가는 것 제외
                if(!"S".equals(prevMove) && prevMove.equals(moveStr[i]) && prevDir != i){
                    continue;
                }

                // 체크3. 벽으로 막혀있는 부분 체크
                if(board[cur.y + moveY[i]][cur.x + moveX[i]] == 1){
                    continue;
                }

                // coner check
                int curCost=Integer.MAX_VALUE;
                if("S".equals(prevMove)){
                    curCost = prevCost + 100;
                }else {
                    curCost = prevCost + 100;
                    if (!moveStr[i].equals(prevMove)) {
                        curCost += 500;
                    }
                }
                if(cost[cur.y + moveY[i]][cur.x + moveX[i]] >= curCost){
                    cost[cur.y + moveY[i]][cur.x + moveX[i]] = curCost;

                    if(!(cur.x + moveX[i] == 0 && cur.y + moveY[i] == 0)) {
                        q.offer(new Coord(cur.x + moveX[i], cur.y + moveY[i], curCost, i, moveStr[i]));
                    }
                }
            }
        }
        return cost[board.length-1][board.length-1];
    }
}

class Coord{
    int x;
    int y;
    int cost;
    int direction;
    String moveStr;

    public Coord(int x, int y, int cost, int direction, String moveStr) {
        this.x = x;
        this.y = y;
        this.cost = cost;
        this.direction = direction;
        this.moveStr = moveStr;
    }
}