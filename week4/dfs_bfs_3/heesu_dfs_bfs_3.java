import java.util.LinkedList;
import java.util.Queue;

class qElement{
    int idx;
    int step;

    qElement(int idx, int step) {
        this.idx = idx;
        this.step = step;
    }
}

class Solution {
    boolean[] visit = new boolean[51]; // 3~50
    Queue<qElement> q = new LinkedList<>();

    boolean isPossibleTobeNext(String cur, String next){
        int cnt = 0;
        for(int i=0;i<cur.length();i++){
            if(cur.charAt(i) == next.charAt(i)) cnt++;
        }

        //하나빼고 다 같은가?
        return cnt == cur.length() - 1;
    }

    int bfs(String[] words, String target, int startIdx){
        int step=1;

        q.offer(new qElement(startIdx, 1));
        visit[startIdx] = true;

        while(!q.isEmpty()){
            qElement curElement = q.poll();
            if(target.equals(words[curElement.idx])){
                step = curElement.step;
                break;
            }

            for(int i=0;i<words.length;i++){
                if(i != curElement.idx && isPossibleTobeNext(words[curElement.idx], words[i])) {
                    int nextIdx = i;

                    if (!visit[nextIdx]) {
                        q.offer(new qElement(nextIdx, curElement.step+1));
                    }
                    visit[nextIdx] = true;
                }
            }
        }

        return step;
    }

    public int solution(String begin, String target, String[] words) {
        int answer = 999999;
        boolean isPossible = false;

        for(int i=0;i<words.length;i++){
            if(target.equals(words[i])){
                isPossible = true;
                break;
            }
        }
        if(!isPossible){
            return 0;
        }else {
            for (int i = 0; i < words.length; i++) {

                //하나만 다른 str(다음 단계로 넘어갈 수 있는) 확인
                if (isPossibleTobeNext(begin, words[i])) {
                    int tmp = bfs(words, target, i);
                    if(answer > tmp) answer = tmp;
                }
            }
            return answer;
        }
    }
}