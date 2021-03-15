import java.util.*;

class Solution {

    public String[] solution(String[] files) {

        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // 첫번째 오브젝트 head, num 추출
                String head1 = s1.split("[0-9]")[0];
                String[] split = s1.split("[0-9]");
                s1 = s1.replace(head1, "");
                head1 = head1.toUpperCase();

                String tempNum = "";
                for(char c : s1.toCharArray()) {
                    if(Character.isDigit(c) && tempNum.length() < 5) {
                        tempNum += c;
                    } else {
                        break;
                    }
                }
                Integer num1 = Integer.parseInt(tempNum);

                // 두번째 오브젝트 head, num 추출
                String head2 = s2.split("[0-9]")[0];
                s2 = s2.replace(head2, "");
                head2 = head2.toUpperCase();

                tempNum = "";
                for(char c : s2.toCharArray()) {
                    if(Character.isDigit(c) && tempNum.length() < 5) {
                        tempNum += c;
                    } else {
                        break;
                    }
                }
                Integer num2 = Integer.parseInt(tempNum);

                // 비교 처리
                return head1.equals(head2) ? num1.compareTo(num2) : head1.compareTo(head2);
            }
        });

        return files;
    }


}