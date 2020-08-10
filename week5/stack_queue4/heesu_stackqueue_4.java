import java.util.LinkedList;
import java.util.Queue;

class Element{
    int index;
    int priority;

    Element(int index, int priority){
        this.index = index;
        this.priority = priority;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Element> q = new LinkedList<>();

        // queue에 삽입
        for(int i=0;i<priorities.length;i++){
            q.add(new Element(i,priorities[i]));
        }

        while(true){
            boolean flag = true;
            // 가장 앞의 요소의 value보다 큰 값이 있는지 체크
            int targetPriority = q.peek().priority;
            for(Element e : q){
                if(targetPriority < e.priority){
                    flag = false;
                    break;
                }
            }
            if(flag){
                Element e = q.poll();
                // pop되는 요소가 location과 같은 경우
                if(e.index == location){
                    break;
                }
            }else{
                Element e = q.poll();
                q.add(e);
            }
        }

        answer = priorities.length - q.size();

        return answer;
    }
}