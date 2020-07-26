/*
 h값의 최대가 주어진 인용횟수 중의 max이므로 0 ~ 최대h 까지 돌면서 조건 확인
 */
import java.util.Arrays;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        for(int i=0;i<=citations[citations.length-1];i++){
            int h = i;
            int hidx = 0;
            for(int j=0;j<citations.length;j++){
                if(citations[j] >= h){
                    hidx = j;
                    break;
                }
            }
            if(citations.length - hidx >= h && hidx+1 <= h) {
                if (answer < h) answer = h;
            }
        }
        return answer;
    }
}