import java.util.*;

class Solution {
    
    static int answer = 0;

    public static int solution(String str1, String str2) {

        //1. 소문자 변환
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        Map<String, Integer> map1 = new HashMap();
        Map<String, Integer> map2 = new HashMap();
        HashSet<String> unionSet = new HashSet<>();

        //2. map1, map2 넣기
        for(int i=0;i<str1.length()-1;i+=1){
            String s = str1.substring(i,i+2);
            if(97> s.charAt(0) || s.charAt(0) >122 || 97> s.charAt(1) || s.charAt(1) >122){
                continue;
            }
            map1.put(s, map1.getOrDefault(s, 0)+1);
        }


        for(int i=0;i<str2.length()-1;i+=1){
            String s = str2.substring(i,i+2);
            if(97> s.charAt(0) || s.charAt(0) >122 || 97> s.charAt(1) || s.charAt(1) >122){
                continue;
            }
            map2.put(s, map2.getOrDefault(s, 0)+1);
        }
        
        //3. 합집합 구함
        unionSet.addAll(map1.keySet());
        unionSet.addAll(map2.keySet());

        int unionSize = 0;
        for (String key : unionSet) {
            int s1 = map1.get(key) != null ? map1.get(key) : 0;
            int s2 = map2.get(key) != null ? map2.get(key) : 0;
            unionSize += Math.max(s1,s2);
        }
        
        //4. 교집합 구함
        Set<String> interSet = map1.keySet();
        interSet.retainAll(map2.keySet());
        System.out.println("교집합 : " + interSet);
        int interSize = 0;
        for (String key : interSet) {
            int s1 = map1.get(key) != null ? map1.get(key) : 0;
            int s2 = map2.get(key) != null ? map2.get(key) : 0;
            interSize += Math.min(s1,s2);
        }

        //5. 65536 곱해주고 소수점 버림
        if(interSize == 0 && unionSize == 0){
            answer = 1 * 65536;
        } else{
            double x = (double)interSize / (double)unionSize * 65536;
            answer = (int) x;
        }

        return answer;
    }


}