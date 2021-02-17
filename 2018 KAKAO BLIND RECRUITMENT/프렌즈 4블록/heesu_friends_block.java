import java.util.ArrayList;
import java.util.List;

class Solution {
    int answer = 0;
    public int solution(int m, int n, String[] board) {
        /*
        m높이  n폭  최대 30이므로 완전탐색 가능
        지우기가능한 x,y 좌표를 저장해놓고 각 x 위치별 y가 얼마나 줄어들 수 있는지 체크해서 블록 move
         */

        List<Coord> coordList = new ArrayList<>();

        // 지울 수 있는 블록 X 마킹
        while(true) {
            int markingCnt = 0;

            for (int y = 0; y < m - 1; y++) {
                for (int x = 0; x < n - 1; x++) {
                    if (isRemovable(x, y, board)) {
                        //바로 X마킹하면.. 누락되는 체크있어서 list에 넣어놓고 한번에 마킹
                        coordList.add(new Coord(x,y));
                        markingCnt++;
                    }
                }
            }

            if(markingCnt == 0) break;

            for(Coord c : coordList){
                markAsX(c.x, c.y, board);
            }
            coordList.clear();

            // 블록 이동
            // x별로 가장 밑에서 부터 y를 확인하면서 X마킹 되어 있는 윗 블록을 내림
            for(int x=0;x<n;x++) {
                for (int y = m-1; y >= 0; y--) {
                    // y 밑에서부터 확인해야 제대로 내릴수있음
                    if(board[y].charAt(x) != 'X'){
                        // X가 아닌 블록은 아래있는 X블록중 제일 낮은 y의 블록과 교체
                        int tgt_y = -1;
                        for(int chk_y = y;chk_y < m;chk_y++){
                            if(board[chk_y].charAt(x) == 'X') tgt_y = chk_y;
                        }
                        if(tgt_y != -1) {
                            replaceChar(y, tgt_y, x, board);
                        }
                    }
                }
            }
        }

        return answer;
    }

    boolean isRemovable(int x, int y, String[] board){
        char block = board[y].charAt(x);
        boolean flag = false;

        if(block == board[y].charAt(x+1)
                && block == board[y+1].charAt(x)
                && block == board[y+1].charAt(x+1)
                && block != 'X'
        ){
            flag = true;
        }

        return flag;
    }

    void markAsX(int x, int y, String[] board){
        for(int yy = y;yy<=y+1;yy++){
            StringBuilder replaceStr = new StringBuilder(board[yy]);

            for(int xx=0;xx<board[yy].length();xx++){
                // x, x+1 중에서 X마킹 안되어있는 부분은 마킹하고 answer++
                if( (xx == x && board[yy].charAt(xx) != 'X') || (xx == x+1 &&  board[yy].charAt(xx) != 'X')){
                    replaceStr.setCharAt(xx, 'X');
                    answer++;
                }
            }
            board[yy] = replaceStr.toString();
        }
    }

    void replaceChar(int cur, int target, int x, String[] board){
        // 동일x의 cur y와 target y의 char를 바꾼다
        StringBuilder curStr = new StringBuilder(board[cur]);
        StringBuilder targetStr = new StringBuilder(board[target]);

        char curChar = board[cur].charAt(x);
        char targetChar = board[target].charAt(x);

        curStr.setCharAt(x, targetChar);
        targetStr.setCharAt(x, curChar);

        board[cur] = curStr.toString();
        board[target] = targetStr.toString();
    }
}
class Coord{
    int x;
    int y;

    public Coord(int _x, int _y){
        this.x = _x;
        this.y = _y;
    }
}