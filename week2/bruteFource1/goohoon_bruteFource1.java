import java.lang.*;
import java.util.*;

class Solution {
    public int[] solution(int[] answers) {

        int[] person1 = {1,2,3,4,5};
        int[] person2 = {2,1,2,3,2,4,2,5};
        int[] person3 = {3,3,1,1,2,2,4,4,5,5};

        int[] answerNum = {0,0,0};

        for(int i=0;i<answers.length;i++){

            if(person1[i%5] == answers[i])
                answerNum[0] += 1;

            if(person2[i%8] == answers[i])
                answerNum[1] += 1;

            if(person3[i%10] == answers[i])
                answerNum[2] += 1;
        }

        int maxScore = Math.max(answerNum[0], Math.max(answerNum[1], answerNum[2]));

        List<Integer> maxNumOrder = new ArrayList<>();
        if(maxScore == answerNum[0]) {maxNumOrder.add(1);}
        if(maxScore == answerNum[1]) {maxNumOrder.add(2);}
        if(maxScore == answerNum[2]) {maxNumOrder.add(3);}

        answers = new int[maxNumOrder.size()];

        for(int i=0;i<maxNumOrder.size();i++){
            answers[i] = maxNumOrder.get(i);
        }

        return answers;
    }
}