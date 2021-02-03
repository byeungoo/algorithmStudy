import java.util.*;

class Solution {

    public static int solution(int m, int n, String[] board) {
        int answer = 0;

        //1. 2차원 배열에 담음
        String[][] newBoard = new String[m][n];
        boolean[][] check = new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                newBoard[i][j] = String.valueOf(board[i].charAt(j));
            }
        }

        //2.  2*2 배열 지우고 밑으로 내리는 과정 반복
        while (true){
            check = new boolean[m][n];
            int count = removeBlock(m, n, newBoard, check);
            answer += count;

            if(count == 0)
                break;

            downBlock(newBoard, m,n);
        }

        return answer;
    }

    //블럭을 내려주는 함수
    public static void downBlock(String[][] newBoard, int m,int n) {
        int idx = 0;

        for(int i=m-1;i>=1;i--) {
            for(int j=0;j<n;j++) {

                idx = i;
                int count = 0;
                
                while(true) {
                    if(idx < 1 && count == 0)   //내려간 블록이 없으면 while문 탈출
                        break;
                    else if(idx < 1 && count != 0){ //블록중 하나라도 내려간게 있으면 다시 반복
                        idx = i;
                        count = 0;
                    }
                    else if(newBoard[i][j].equals("*") && !newBoard[idx-1][j].equals("*")) {
                        //바꾼다
                        String tmp = newBoard[idx][j];
                        newBoard[idx][j]=newBoard[idx-1][j];
                        newBoard[idx-1][j]=tmp;
                        count++;
                    } else
                        idx--;
                }
            }
        }
    }

    public static int removeBlock(int m, int n, String[][] newBoard, boolean[][] check){

        int count = 0;

        // 2*2 블록인곳 check true
        for(int i=0;i<m-1;i++){
            for(int j=0;j<n-1;j++){
                String s = newBoard[i][j];
                if((!s.equals("*")) && (s.equals(newBoard[i][j+1]) && s.equals(newBoard[i+1][j]) && s.equals(newBoard[i+1][j+1]))) {
                    check[i][j]=true;
                    check[i][j+1]=true;
                    check[i+1][j]=true;
                    check[i+1][j+1]=true;
                }
            }
        }

        //newBoard에서 true인 곳 제거
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(check[i][j]==true) {
                    newBoard[i][j]="*";
                    count += 1;
                }
            }
        }

        return count;
    }
    
}