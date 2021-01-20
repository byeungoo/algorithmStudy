import static java.lang.Math.abs;
class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int curLeft = 10; // *
        int curRight= 12; // #

        for(int i=0;i<numbers.length;i++) {
            // 0을 11로 변환
            if(numbers[i] == 0) numbers[i] = 11;

            // 왼쪽 키패드
            if(numbers[i] != 11 && numbers[i] % 3 == 1){
                answer.append("L");
                curLeft = numbers[i];
            }
            // 오른쪽 키패드
            else if(numbers[i] != 11 && numbers[i] % 3 == 0){
                answer.append("R");
                curRight = numbers[i];
            }
            // 중앙 키패드
            else{
                int lDist = getDist(curLeft, numbers[i]);
                int rDist = getDist(curRight, numbers[i]);

                if(lDist > rDist || (lDist == rDist && "right".equals(hand))){
                    answer.append("R");
                    curRight = numbers[i];
                }
                else if(lDist < rDist || (lDist == rDist && "left".equals(hand))){
                    answer.append("L");
                    curLeft = numbers[i];
                }
            }
        }

        return answer.toString();
    }
    public int getDist(int cur, int target){
        int curX = (cur-1) % 3;
        int curY = (cur-1) / 3;
        int targetX = (target-1) % 3;
        int targetY = (target-1) / 3;

        return abs(targetX - curX) + abs(targetY - curY);
    }
}