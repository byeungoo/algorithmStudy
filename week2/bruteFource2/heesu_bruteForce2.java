import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    boolean[] visit = new boolean[8];
    HashSet<Integer> setObj = new HashSet<>();

    boolean isPrime(int target){
        int flagCnt=0;
        for(int i=1;i<=target;i++){
            if(target % i ==0) flagCnt++;
        }
        if(flagCnt == 2) return true;
        else return false;
    }

    void perm (String[] nums, String curStr, int idx, int cnt) {
        if(cnt == idx){
            if(!"".equals(curStr) && curStr.charAt(0) != '0') setObj.add(Integer.parseInt(curStr));
            return;
        }
        for(int i=0;i<cnt;i++) {
            //이미 방문한 곳 제외
            if(visit[i]) continue;

            visit[i] = true;
            perm(nums, curStr+nums[i],idx + 1, cnt);
            visit[i] = false;
            perm(nums, curStr,idx + 1, cnt);
        }
    }
    public int solution(String numbers) {
        int answer = 0;
        String[] nums = new String[numbers.length()];

        for (int i = 0; i < numbers.length(); i++) {
            nums[i] = numbers.charAt(i) + "";
        }

        // idx->0부터 n개의 모든 요소가 선택될때까지 perm() 수행
        perm(nums, "" ,0, numbers.length());

        ArrayList<Integer> numList = new ArrayList<>(setObj);
        for(Integer element : numList){
            if(isPrime(element.intValue())) answer++;
        }

        return answer;
    }
}