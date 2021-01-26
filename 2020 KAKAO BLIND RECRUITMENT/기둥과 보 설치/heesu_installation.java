import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer;

        List<Structure> structures = new ArrayList<>();

        // input 핸들링
        for(int i=0;i<build_frame.length;i++) {
            // 값 셋팅
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int type = build_frame[i][2];
            int action = build_frame[i][3];

            Structure s = new Structure(x, y, type);
            // 규칙 체크
            if (checkStatus(n, structures, s, action)) {
                // 규칙에 맞고 추가인 경우에만 building에 추가
                if(action == 1){
                    structures.add(s);
                }else if(action == 0){
                    structures.remove(s);
                }
            }
        }

        structures.sort(Comparator.comparing(Structure::getX).thenComparing(Structure::getY)
                .thenComparing(Structure::getType));

        answer = new int[structures.size()][3];
        int idx = 0;
        for(Structure structure : structures){
            answer[idx][0] = structure.x;
            answer[idx][1] = structure.y;
            answer[idx][2] = structure.type;

            idx++;
        }

        return answer;
    }
    boolean checkStatus(int n, List<Structure> structures, Structure tgt, int action){
        boolean flag = true;

        // add
        if(action == 1) {
            // n*n 벗어나는 경우
            if ((tgt.type == 0 && tgt.y + 1 > n) || (tgt.type == 1 && tgt.x + 1 > n)) {
                flag = false;
            }

            // 기둥 -> 바닥위 , 보의 한쪽끝, 다른 기둥 위
            if (tgt.type == 0) {
                boolean buildable = false;
                boolean hori_left = false;
                boolean hori_right = false;

                if (tgt.y == 0) {
                    buildable = true;
                } else {
                    for (Structure s : structures) {
                        if (s.type == 0 && (s.x == tgt.x && s.y == tgt.y - 1)) {
                            buildable = true;
                            break;
                        } else if (s.type == 1){ //&& (s.x == tgt.x - 1 && s.y == tgt.y)) {
                            if(s.x == tgt.x - 1 && s.y == tgt.y){
                                hori_left = true;
                            }else if(s.x == tgt.x && s.y == tgt.y){
                                hori_right = true;
                            }
                        }
                    }
                    // 기둥이 보의 '한 쪽' 끝에만 달려있는 경우 체크
                    if (hori_left || hori_right) buildable = true;
                }

                if (!buildable) flag = false;
            }

            // 보 -> 한 쪽이 기둥 위 , 양쪽이 다른 보와 연결
            else if (tgt.type == 1) {
                boolean buildable = false;
                boolean vert_left = false;
                boolean vert_right = false;

                for (Structure s : structures) {
                    if (s.type == 0) {
                        // 보 한쪽이 이미 지어진 기둥의 위인 경우
                        if ((s.x == tgt.x || s.x - 1 == tgt.x) && s.y == tgt.y - 1) {
                            buildable = true;
                            break;
                        }
                    } else if (s.type == 1) {
                        // 양쪽이 다른 보와 연결되어있는지 체크
                        if (s.x == tgt.x - 1 && s.y == tgt.y) {
                            vert_left = true;
                        } else if (s.x == tgt.x + 1 && s.y == tgt.y) {
                            vert_right = true;
                        }
                    }
                }
                if (vert_left && vert_right) buildable = true;

                if (!buildable) flag = false;
            }
        }
        //delete
        else if(action == 0){
            boolean deletable = true;
            // 일단 지워놓고 나머지 structure에 대한 전체 체크

            for(Structure deleteTgt : structures) {
                if(tgt.equals(deleteTgt)) {
                    structures.remove(deleteTgt);
                    break;
                }
            }

            for(Structure tmptgt : structures){
                List<Structure> tmpStructures = new ArrayList<>();
                tmpStructures.addAll(structures);

                for(Structure deleteTgt : tmpStructures) {
                    if(tmptgt.equals(deleteTgt)) {
                        tmpStructures.remove(deleteTgt);
                        break;
                    }
                }
                if(!checkStatus(n, tmpStructures, tmptgt, 1)) { // 추가action으로 변경해서 재귀 호출
                    deletable = false;
                    break;
                }
                tmpStructures.add(tmptgt);
            }

            if(!deletable){
                flag = false;
                // 지우는게 불가능하면 다시 추가해놔야함
                structures.add(tgt);
            }
        }

        return flag;
    }
}

class Structure{
    int x;
    int y;
    int type;

    public Structure(int _x, int _y, int _type){
        this.x = _x;
        this.y = _y;
        this.type = _type;
    }

    public boolean equals(Structure obj) {
        return (this.x == obj.x && this.y == obj.y && this.type == obj.type);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}