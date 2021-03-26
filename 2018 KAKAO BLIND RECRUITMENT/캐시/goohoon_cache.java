import java.util.*;

//프로그래머스 2018 KAKAO BLIND RECRUITMENT
//https://programmers.co.kr/learn/courses/30/lessons/17680

class Solution {

    public int solution(int cacheSize, String[] cities) {

        Deque<String> cache = new ArrayDeque<>();
        int answer = 0;

        int len = cities.length;
        for(int i=0;i<len;i++){
            cities[i] = cities[i].toLowerCase();
        }

        for(int i=0;i<len;i++){

            if(cacheSize == 0){
                answer += 5;
            } else if(cache.contains(cities[i])){
                cache.remove(cities[i]);
                cache.addFirst(cities[i]);
                answer += 1;
            } else if(!cache.contains(cities[i]) && cache.size() < cacheSize){
                answer += 5;
                cache.addFirst(cities[i]);
            } else{
                answer += 5;
                cache.removeLast();
                cache.addFirst(cities[i]);
            }

        }

        System.out.println(answer);

        return answer;
    }

}