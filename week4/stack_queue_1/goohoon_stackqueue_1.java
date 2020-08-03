class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        int size = prices.length;
        
        for(int i=0;i<size;i++){
            
            int curNum = prices[i];
            int time = 0;
            
            for(int j=i+1;j<size;j++){
                int nextNum = prices[j];
                
                if(curNum <= nextNum){
                    time++;
                } else{
                    time++;
                    break;
                }
            }
            
            answer[i] = time;
        }
                
        return answer;
    }
}