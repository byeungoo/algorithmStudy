class Solution {

    public int[] calRectangle(int brown, int yellow){
        int[] arr = new int[2];
        int sum = brown + yellow;
        for(int i=3;i<=sum;i++){
            if(sum%i == 0){
                Integer x = sum/i; //x가 무조건 더큼, 가로
                int calBrownNum = 2*x + i*2-4;
                if(brown == calBrownNum){
                    arr[0] = x;
                    arr[1] = i;
                    return arr;
                }                
            }
        }
        
        return arr;
    }

    public int[] solution(int brown, int yellow) {
        int[] answer = calRectangle(brown, yellow);
        return answer;
    }
}