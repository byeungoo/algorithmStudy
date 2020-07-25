/*
 Arrays.sort() 메서드를 사용해서 호출 시, comparator를 배열 두 요소 e1, e2에 대해서 e1+e2, e2+e1으로 비교하도록 처리
 */
import java.util.Arrays;
class Solution {
    public String solution(int[] numbers) {
        String[] str_array = new String[numbers.length];

        String answer = "";

        for(int i=0;i<numbers.length;i++){
            str_array[i] = numbers[i] + "";
        }

        Arrays.sort(str_array, (e1, e2) -> Integer.parseInt(e2+e1) - Integer.parseInt(e1+e2));
        for(int i=0;i<str_array.length;i++){
            answer += str_array[i];
            if(i==0 && answer.equals("0")) break;
        }
        return answer;
    }
}