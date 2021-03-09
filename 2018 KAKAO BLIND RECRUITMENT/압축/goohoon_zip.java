import java.util.ArrayList;
import java.util.List;

class Solution {
    
    public static List<String> dictionary = new ArrayList<>();

    public static void initDictionary(){
        for(int i=1;i<=26;i++){
            dictionary.add(String.valueOf((char)(64 + i)));
        }
    }

    public static int[] solution(String msg) {
        List<Integer> list = new ArrayList<>();

        initDictionary();

        int i = 0;
        while (true){

            //사전에서 가장 긴거 찾는다.
            int index = -1;
            String target = "";
            for(int j=0;j<dictionary.size();j++){
                String word = dictionary.get(j);

	    //사전에 있는 word와 현재 index로부터 word 만큼의 길이중 같고 기존 target의 길이보다 길 경우 업데이트
                if(i+word.length() <= msg.length() && word.equals(msg.substring(i,i+word.length())) && word.length()>target.length()){
                    target = word;
                    index = j+1;
                }

            }

            list.add(index);
            i += target.length();

            //같아질 경우 종료
            if(i == msg.length())
                break;

            //사전에 없는 경우 추가
            String newWord = target+ msg.charAt(i);
            if(!dictionary.contains(newWord)){
                dictionary.add(newWord);
            }
            
        }

        int[] answer = new int[list.size()];
        for (int t=0;t<list.size();t++) {
            answer[t] = list.get(t);
        }

        return answer;
    }
    
}