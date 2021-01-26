class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int lockCnt = 0;

        // lock 비어 있는 부분 갯수 확인
        for(int i=0;i<lock.length;i++){
            for(int j=0;j<lock.length;j++){
                if(lock[i][j] == 0) lockCnt++;
            }
        }

        /*
         -key size ~ lock+ key size 만큼 확인
         4(rotate) * 가지수 전체확인(60*60) * 체크(20*20) =>  시간초과 발생 X
         */

        // 1. rotate
        int[][] targetKey = new int[key.length][key.length];
        for(int r=0;r<4;r++){
            targetKey = doRotation(key, r); // r은 rotation 처리를 위한 변수


            // 2. 가지수 전체 확인
            for(int y=-key.length;y<lock.length + key.length;y++) {
                for (int x = -key.length; x < lock.length + key.length; x++) {

                    // 3. 체크

                    int filledLockCnt = 0;
                    for (int ky = 0; ky < targetKey.length ; ky++) {
                        for (int kx = 0; kx < targetKey.length ; kx++) {
                            // 범위 벗어나는 부분은 체크 X
                            if (y+ky < 0 || x+kx < 0 || y+ky > lock.length-1 || x+kx > lock.length-1) {
                                continue;
                            }

                            if(targetKey[ky][kx] == 1 && lock[y+ky][x+kx]==0){
                                filledLockCnt++;
                            }else if(targetKey[ky][kx] == 1 && lock[y+ky][x+kx]==1){
                                // 돌기끼리 만나는 부분이 있으면 해당케이스는 체크X
                                break;
                            }
                        }
                    }
                    if(filledLockCnt == lockCnt){
                        answer = true;
                        break;
                    }
                }
            }
        }

        return answer;
    }

    int[][] doRotation(int[][] key, int r){
        /*
        r = 1 -> 90
        r = 2 -> 180 ..
         */
        int length = key.length;
        int[][] targetKey = new int[length][length];

        /*
        s~ 시작 위치 e~ 끝 위치
        r~ 읽는 방향
         */
        int[] sx = new int[]{0,0,length-1,length-1};
        int[] sy = new int[]{0,length-1,length-1,0};
        int[] ex = new int[]{length-1,length-1,0,0};
        int[] ey = new int[]{length-1,0,0,length-1};
        int[] rx = new int[]{1,1,-1,-1};
        int[] ry = new int[]{1,-1,-1,1};

        int idx = 0;

        if(r%2 == 0) {
            // 0, 180도 회전은 가로열부터 쌓음
            for (int y = sy[r]; ey[r] == 0 ? y >= ey[r] : y <= ey[r]; y += ry[r]) {
                for (int x = sx[r]; ex[r] == 0 ? x >= ex[r] : x <= ex[r]; x += rx[r]) {

                    targetKey[idx / length][idx % length] = key[y][x];
                    idx++;
                }
            }
        }else{
            // 90, 270도 회전은 세로행부터 쌓음
            for (int x = sx[r]; ex[r] == 0 ? x >= ex[r] : x <= ex[r]; x += rx[r]) {
                for (int y = sy[r]; ey[r] == 0 ? y >= ey[r] : y <= ey[r]; y += ry[r]) {
                    targetKey[idx / length][idx % length] = key[y][x];
                    idx++;
                }
            }
        }

        return targetKey;
    }
}