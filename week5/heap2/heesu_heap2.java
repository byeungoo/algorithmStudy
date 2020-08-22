import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int start = 0;
        int sum = 0;

        PriorityQueue<Element> q = new PriorityQueue<>();
        //요청순서대로 정렬
        Arrays.sort(jobs,  (o1, o2) -> o1[0] - o2[0]);

        int idx = 0;
        while(idx < jobs.length || !q.isEmpty()){
            // pq에 수행가능한 작업 추가
            while(idx <jobs.length && jobs[idx][0] <= start){
                q.offer(new Element(jobs[idx][0], jobs[idx][1]));
                idx++;
            }

            if(q.isEmpty()){
                // start보다 이후 시간에 들어오는 작업만 있는 경우
                start = jobs[idx][0];
            }else{
                Element target = q.poll();
                sum += target.getReqToEndTime(start);
                start += target.spend;
            }

        }

        answer = sum / jobs.length;
        return answer;
    }
}

class Element implements Comparable<Element>{
    int req;
    int spend;

    Element(int req, int spend){
        this.req = req;
        this.spend = spend;
    }

    int getReqToEndTime(int start){
        return start + spend - req;
    }

    @Override
    public int compareTo(Element o) {
        return this.spend > o.spend ? 1 : -1;
    }
}