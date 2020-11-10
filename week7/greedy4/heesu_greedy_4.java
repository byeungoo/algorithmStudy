import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int start = 0;
        int end = people.length-1;
        int cur = end;
        int pair=0;

        Arrays.sort(people);
        while(start < end){
            if(people[start]+people[end] <= limit){
                pair++;
                end--;
                start++;
            }else{
                end--;
            }
        }

        return people.length - pair;
    }
}