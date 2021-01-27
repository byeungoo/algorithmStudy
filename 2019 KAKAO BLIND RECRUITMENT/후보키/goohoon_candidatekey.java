import java.util.*;

class Solution {
    static ArrayList<HashSet<Integer>> candidateKey = new ArrayList<HashSet<Integer>>();;
    static String Table[][];
    static int length;
    static int answer;

    public static int solution(String[][] relation) {

        Table = relation;
        length = relation[0].length;    //col 길이

        for(int i = 1; i <= length; i++) {
            makeSet(-1, i, 0, new HashSet<Integer>());
        }

        return answer;
    }

    public static void makeSet(int index, int target, int count, HashSet<Integer> set) {        //target : 목표 key 개수

        if(count == target) {   //key set의 수와 target의 수가 같을경우
            if(!isUnique(set)) {    //set이 unique하지 않으면 종료
                return;
            }
            for(HashSet<Integer> key: candidateKey) {   //이미 후보키에 포함되있으면 종료
                if(set.containsAll(key)) {
                    return;
                }
            }
            candidateKey.add(set);
            answer++;
            return;
        }

        for(int i = index + 1; i < length; i++) {       //key set을 만들어줌
            HashSet<Integer> newSet = new HashSet<Integer>(set);
            newSet.add(i);
            makeSet(i, target, count + 1, newSet);
        }

    }

    public static boolean isUnique(HashSet<Integer> set) {
        ArrayList<String> list = new ArrayList<String>();   //키의 조합을 list에 담아줌
        for(int i = 0; i < Table.length; i++) { //
            String temp = "";
            for(int index: set) //키에 들어있는 값을 더함
                temp+= Table[i][index];
            if(!list.contains(temp))    //temp값이 list에 없으면 더해줌
                list.add(temp);
            else    //temp 값이 list에 있으면 최소성을 만족하지 않으므로 종료
                return false;
        }
        return true;
    }
}