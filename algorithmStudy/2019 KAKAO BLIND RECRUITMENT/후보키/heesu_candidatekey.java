import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Solution {
    Set<String> keySet = new HashSet<>();
    Set<String> rowSet = new HashSet<>();
    int answer = 0;

    public int solution(String[][] relation) {
        /*
         col -> 최대 8
         row -> 최대 20
         */

        // 후보키로 선택하는 컬럼수
        int colCnt = relation[0].length;
        for(int i=1;i<=colCnt;i++) {
            rowSet.clear();

            combination(relation, new int[colCnt], colCnt, i, 0, 0, 0);
        }

        return answer;
    }

    void combination(String[][] relation, int[] selected, int n, int r, int depth, int index, int target) {
        if(depth==r){
            boolean isUniq = true;
            boolean isMin = true;

            StringBuilder keyStr = new StringBuilder();
            StringBuilder keyIdxStr = new StringBuilder();

            for(int i=0;i<relation.length;i++) {
                keyStr.setLength(0);
                keyIdxStr.setLength(0);

                for (int j=0;j<r;j++) {
                    keyIdxStr.append(selected[j]);
                    keyStr.append(relation[i][selected[j]]).append(":");
                }

                if (!rowSet.contains(keyStr.toString())) {
                    rowSet.add(keyStr.toString());
                } else {
                    // 유일성 위배
                    isUniq = false;
                    break;
                }
            }

            if(isUniq){
                // keySet에서 최소성 확인
                Iterator<String> it = keySet.iterator();
                while(it.hasNext()){
                    String key = it.next();
                    String tmpKey = keyIdxStr.toString();
                    int sameCnt = 0;

                    for(int i=0;i<key.length();i++){
                        String s = key.charAt(i)+"";
                        if(tmpKey.indexOf(s) > -1) { // 한글자씩 때놓고 확인
                            sameCnt++;
                        }
                    }
                    if(sameCnt == key.length()) isMin = false;
                }
                if(isMin) {
                    answer++;
                    keySet.add(keyIdxStr.toString());
                }
            }

            rowSet.clear();

            return;
        }
        if(target == n) return;

        selected[index] = target;
        combination(relation, selected, n, r, depth+1, index+1, target+1); //뽑는경우
        combination(relation, selected, n, r, depth, index, target+1);                 //안뽑는경우
    }
}