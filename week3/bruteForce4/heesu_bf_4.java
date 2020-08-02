class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int totalCnt = brown+yellow;

        for(int x=3;x<=totalCnt/3;x++){
            if(totalCnt%x >0 || totalCnt/x>x) continue;
            int y= totalCnt / x;
            int outerCnt = (x*2)+(y*2)-4;

            if(totalCnt - outerCnt == yellow){
                answer[0] = x;
                answer[1] = y;
                break;
            }
        }

        return answer;
    }
}