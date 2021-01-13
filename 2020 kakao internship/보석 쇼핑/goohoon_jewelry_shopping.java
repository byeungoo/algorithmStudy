import java.util.*;

class Solution {

    public int[] solution(String[] gems) {
        int[] answer = new int[2];

        HashSet<String> set = new HashSet<>();
        set.addAll(Arrays.asList(gems));

        int n = gems.length;
        int distance = Integer.MAX_VALUE;
        
        //정답 저장
        int start = 0;
        int end = 0;
        
        //범위
        int left = 0;
        int right = 0;

        HashMap<String, Integer> map = new HashMap<>();

        while (true) {
            if(map.size() >= set.size()){  //left 오른쪽 이동
                map.put(gems[left], map.getOrDefault(gems[left],0) - 1);

                if(map.get(gems[left]) == 0)
                    map.remove(gems[left]);

                left++;
            } else if(right == n){
                break;
            } else { //right 오른쪽 이동
                if(right<n) {
                    map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
                    right++;
                }
            }

            if(map.size() == set.size() && right-left<distance){
                distance = right-left;
                start = left+1;
                end = right;
            }
        }

        answer[0] = start;
        answer[1] = end;

        return answer;
    }
    
}