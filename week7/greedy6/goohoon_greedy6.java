import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;

        // 카메라의 갯수
        int camera = -30001;

        // 카메라의 위치
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        for (int[] route : routes) {
            if (camera < route[0]) { 
                camera = route[1]; 
                answer++; 
            }
        }

        return answer;
    }

}