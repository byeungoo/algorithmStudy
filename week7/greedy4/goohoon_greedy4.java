import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int s = 0;
        int e =  people.length-1;

        while(s <= e){

            if(people[s] + people[e] <= limit){
                answer++;
                s++;
                e--;
            } else{
                answer++;
                e--;
            }
        }

        return answer;
    }
}