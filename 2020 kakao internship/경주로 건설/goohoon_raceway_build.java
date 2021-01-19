import java.util.*;

class Solution {
    static int answer = Integer.MAX_VALUE;
    static int size = 0;
    static int[][] next = { {0,1}, {1,0}, {-1,0}, {0, -1} };

    public static int solution(int[][] board) {
        size = board.length;
        int[][] boardArr = new int[size+2][size+2];
        initData(board, boardArr);
        bfs(boardArr, 1, 1, 0, null);
        return answer;
    }

    private static void bfs(int[][] boardArr, int x, int y, int cost, String dir){

        Queue<Car> q = new LinkedList<>();
        Car car = new Car(1, 1, null, 0);
        boardArr[1][1] = 1;
        q.add(car);

        while (!q.isEmpty()){

            Car curCar = q.poll();

            //base case
            if(curCar.x == size && curCar.y == size){
                answer = Math.min(curCar.cost, answer);
                continue;
            }

            for(int i=0;i<4;i++){
                int nx = curCar.x + next[i][0];
                int ny = curCar.y + next[i][1];

                String nextDir = "";
                if(i == 0 || i == 3)
                    nextDir = "h";
                else if(i == 1 || i == 2)
                    nextDir = "v";

                int nextCost = curCar.calculateNextCost(nextDir);

                if(boardArr[nx][ny] == 0){
                    Car nextCar = new Car(nx, ny, nextDir, nextCost );
                    boardArr[nx][ny] = nextCost;
                    q.add(nextCar);
                } else if(boardArr[nx][ny] >= nextCost){
                    Car nextCar = new Car(nx, ny, nextDir, nextCost);
                    boardArr[nx][ny] = nextCost;
                    q.add(nextCar);
                }
            }
        }
    }

    private static void initData(int[][] board, int[][] boardArr) {
        int len = boardArr.length;
        for(int i=0;i<len;i++)
            Arrays.fill(boardArr[i], 1);

        for(int i=1;i<len-1;i++)
            for(int j=1;j<boardArr.length-1;j++)
                boardArr[i][j] = board[i-1][j-1];
    }

}

class Car{

    public int x;
    public int y;
    public String dir;
    public int cost;

    Car(int x, int y, String dir, int cost){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.cost = cost;
    }

    int calculateNextCost(String nextDir){
        int cost = this.cost;
        if(this.dir == null){
            cost += 100;
        } else if(this.dir.equals(nextDir)){
            cost += 100;
        } else if(!this.dir.equals(nextDir)){
            cost += 600;
        }
        return cost;
    }

}