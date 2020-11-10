class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int numLen = number.length();
        int answerLen = numLen - k;
        int startIdx = 0;

        while (true) {
            char maxChar = '0';
            for(int i=startIdx;i<numLen-answerLen+answer.length()+1;i++){
                if(number.charAt(i) == '9'){
                    maxChar = '9';
                    startIdx = i+1;
                    break;
                }

                if(maxChar < number.charAt(i)){
                    maxChar = number.charAt(i);
                    startIdx = i+1;
                }

            }
            answer.append(maxChar);
            if(answer.length() == answerLen) break;
        }

        return answer.toString();
    }
}