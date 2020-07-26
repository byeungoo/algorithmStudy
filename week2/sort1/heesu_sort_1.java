/*
 - Arrays.copyOfRange, sort 메서드 사용하면 코드 훨씬 간결해짐.
*/
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0;i<commands.length;i++){
            int sIdx = commands[i][0] - 1;
            int eIdx = commands[i][1] - 1;
            int[] tmpArr = new int[eIdx - sIdx + 1];

            for(int j=sIdx;j<=eIdx;j++){
                tmpArr[j-sIdx] = array[j];
            }

            for(int j=0;j<tmpArr.length;j++){
                for(int k=j+1;k<tmpArr.length;k++){
                    if(tmpArr[j] > tmpArr[k]){
                        int tmp = tmpArr[k];
                        tmpArr[k] = tmpArr[j];
                        tmpArr[j] = tmp ;
                    }
                }
            }
            answer[i] = tmpArr[commands[i][2] - 1];
        }
        return answer;
    }
}