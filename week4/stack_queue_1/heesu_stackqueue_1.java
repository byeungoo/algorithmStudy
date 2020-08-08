class Solution {
    int[] answer;

    public int[] solution(int[] prices) {
        answer = new int[prices.length];

        for(int i=0;i<prices.length-1;i++){
            useStack(i, i+1, prices.length-1, prices);
        }
        return answer;
    }

    void useStack(int idx, int nextIdx, int endIdx, int[] prices){

        if(nextIdx == endIdx || prices[idx] > prices[nextIdx] ){
            answer[idx] = nextIdx - idx;
            return;
        }

        useStack(idx, nextIdx+1, endIdx, prices);
    }
}