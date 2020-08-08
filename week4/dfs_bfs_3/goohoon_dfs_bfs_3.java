class Solution {
    
    int minNum = 999999999;
    
    public void dfs(boolean[] visit, String[] words, String word, String target, int depth){
    
        if(isAllVisit(visit) == true)
            return;
        
        if(word.equals(target)){
            if(depth < minNum)
                minNum = depth;
            return;
        }
        
        int len = words.length;
        for(int i=0;i<len;i++){
            
            if(visit[i] == true)
                continue;
            
            if(isChngAble(word, words[i])){
                visit[i] = true;
                dfs(visit, words, words[i], target, depth+1);
                visit[i] = false;
            }
        }
    }
    
    public boolean isAllVisit(boolean[] visit){
        boolean isAllVisit = false;
        int len = visit.length;
        
        for(int i=0;i<len;i++){
            if(visit[i] == false)
                return false;  
        }
        
        return isAllVisit;
    }
    
    public boolean isChngAble(String word, String targetWord){
        boolean isChngAble = false;
        int sameCharNum = 0;
        int len = word.length();
        for(int i=0;i<len;i++){
            if(word.charAt(i) == targetWord.charAt(i))
                sameCharNum++;
        }
        
        if(len-1 == sameCharNum)
            isChngAble=true;
        
        return isChngAble;
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        boolean[] visit = new boolean[words.length];
        
        dfs(visit, words, begin, target, 0);
        
        if(minNum == 999999999){
            return 0;
        } else {
            return minNum;
        }
    }
}