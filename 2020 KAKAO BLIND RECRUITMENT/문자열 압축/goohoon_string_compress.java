import java.util.*;

class Solution {

    public static int solution(String s) {

        int min = s.length();

        for(int i=1;i<=s.length();i++){
            List<String> list = new ArrayList<>();

            //list에 i만큼 나눠서 넣음
            for(int j=0;j<s.length();j+=i){
                int start = j;
                int end = start+i;
                String word = end>=s.length() ?  s.substring(start) : s.substring(start, end);
                list.add(word);
            }

            String compressed = "";
            int count = 1;
            for(int t=0;t<list.size();t++){ //앞에 문자와 뒤의 문자가 같은지 검사
                if(t == list.size()-1){ //마지막 단어의 경우

                    if(count == 1)
                        compressed += list.get(t);
                    else{
                        compressed += String.valueOf(count) + list.get(t);
                    }

                } else if(list.get(t).equals(list.get(t+1)))    //앞에 단어와 같은 경우
                    count++;
                else{   //앞과 뒤의 단어가 다른 경우
                    if(count == 1)
                        compressed += list.get(t);
                    else {
                        compressed += String.valueOf(count) + list.get(t);
                        count = 1;
                    }
                }
            }

            if(min>compressed.length())
                min = compressed.length();
        }

        return min;
    }

    public static void main(String[] args) throws Exception{
        String s = "aabbaccc";
        solution(s);
    }
}