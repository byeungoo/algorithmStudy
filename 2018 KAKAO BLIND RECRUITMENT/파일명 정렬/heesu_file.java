import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        int answerIdx = 0;
        /*
         - head(문자 대소문자 구분 X) -> number 순서로 정렬
         - number는 최대 1~5 글자
         */

        List<File> fileList = new ArrayList<>();

        for(int i=0;i<files.length;i++){
            String[] splitedStr = getSplitedStr(files[i]);
            fileList.add( new File(i, splitedStr[0], strNumberToInt(splitedStr[1])) ); // 원 배열에 대한 요소의 idx도 같이 저장
        }

        fileList.sort(Comparator.comparing(File::getHead).thenComparing(File::getNumber));

        for(File file : fileList){
            answer[answerIdx++] = files[file.idx];
        }

        return answer;
    }

    public String[] getSplitedStr(String str){
        String[] strArr = new String[2];
        boolean numFlag = false; // number와 tail을 끊기 위해서 사용
        int numStartIdx = 0;

        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);

            if(c >= '0' && c<= '9'){
                // number 시작
                if(!numFlag){
                    numFlag = true;
                    numStartIdx = i;
                    strArr[0] = (str.substring(0,i)).toUpperCase(); // 대소문자 구분을 없애기 위해서 대문자로 변환
                }

                if(numFlag){
                    if (i == str.length() - 1) { //tail이 없는 경우
                        strArr[1] = str.substring(numStartIdx, str.length());
                        break;
                    }else if(i-numStartIdx > 4){ //number가 5자리 이상인 경우
                        strArr[1] = str.substring(numStartIdx, i);
                        break;
                    }
                }
            }else{
                if(numFlag){
                    // tail 시작
                    strArr[1] = str.substring(numStartIdx, i);
                    break;
                }
            }
        }

        return strArr;
    }

    public int strNumberToInt(String strNum){
        // 앞의 0을 제외한 숫자 int 반환
        int num = 0;
        int idx = 0;
        while(true){
            if(strNum.charAt(idx) == '0'){
                idx++;
                if(idx == strNum.length()){
                    num = 0; // 0000같은 케이스
                    break;
                }
            }else{
                num = Integer.parseInt(strNum.substring(idx,strNum.length()));
                break;
            }
        }

        return num;
    }
}

class File{
    int idx;
    String head;
    int number;

    public File(int idx, String head, int number) {
        this.idx = idx;
        this.head = head;
        this.number = number;
    }

    public String getHead() {
        return head;
    }

    public int getNumber() {
        return number;
    }
}
