import java.util.*;

class Solution {

    PriorityQueue<Job> waitQueue = new PriorityQueue<>();
    Boolean[] visit;
    
    int time = 0;
    int totalReqAvgTime = 0;
    
    public void addWaitQueue(int[][] jobs){
        int size = visit.length;
        for(int i=0;i<size;i++){
            if(time>=jobs[i][0] && visit[i] == false){
                waitQueue.add(new Job(jobs[i][0], jobs[i][1]));
                visit[i] = true;
            }
        }
    }
    
    public Boolean isAllVisit(){
        int size = visit.length;
        for(int i=0;i<size;i++){
            if(visit[i] == false)
                return false;
        }
        return true;
    }
    
    public int solution(int[][] jobs) {

        visit = new Boolean[jobs.length];
        
        //Visit 배열 초기화
        for(int i=0;i<jobs.length;i++){
            visit[i] = false;
        }
        
        //배열 요청 시간순으로 정렬
        Arrays.sort(jobs, new Comparator<int[]>(){
            @Override
            public int compare(int[] j1, int[] j2){
                return j1[0] - j2[0];
            }
        });

        while(!(isAllVisit() == true && waitQueue.isEmpty())){
            addWaitQueue(jobs);
            if(!waitQueue.isEmpty()){
                Job front = waitQueue.poll();
                time += front.getPrcTime();
                totalReqAvgTime += time - front.getReqTime();
            } else{
                time++;
            }
        }
        
        return totalReqAvgTime/jobs.length;
    }
    
    class Job implements Comparable<Job>{
        
        private int reqTime;
        private int prcTime;
        
        public int getPrcTime(){
            return this.prcTime;
        }
        
        public int getReqTime(){
            return this.reqTime;
        }
        
        public Job(int reqTime, int prcTime){
            this.reqTime = reqTime;
            this.prcTime = prcTime;
        }
        
        @Override
        public int compareTo(Job job){
            return this.prcTime - job.getPrcTime();
        }
    }
}