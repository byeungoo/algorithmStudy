import java.util.*;

class Solution {
    HashMap<String, ArrayList<String>> mapObj = new HashMap<>();
    boolean getAnswer = false;
    String[] answer;

    public String[] solution(String[][] tickets) {
        TreeMap<String, Integer> tickedUsedChk = new TreeMap<>();

        // 인접행렬 구성
        for(int i=0;i<tickets.length;i++){
            if(mapObj.get(tickets[i][0]) != null ){
                mapObj.get(tickets[i][0]).add(tickets[i][1]);
            }else {
                ArrayList<String> tmpList = new ArrayList<>();
                tmpList.add(tickets[i][1]);
                mapObj.put(tickets[i][0], tmpList);
            }
            tickedUsedChk.put(tickets[i][0]+":"+tickets[i][1], tickedUsedChk.getOrDefault(tickets[i][0]+":"+tickets[i][1],0) + 1);
        }
        dfs("ICN", tickedUsedChk, new String[tickets.length+1], 0);

        return answer;
    }

    public void dfs(String curCity,
                    TreeMap<String, Integer> tickedUsedChk,
                    String[] route,
                    int curIdx){

        route[curIdx] = curCity;
        if(getAnswer) return;
        if(chkFunc(tickedUsedChk, route, tickedUsedChk.size()+1) && !getAnswer ){
            getAnswer = true;
            answer = route.clone();
            return;
        }

        // 정렬
        Iterator<String> iteratorKey = tickedUsedChk.keySet().iterator(); // key값에 대한 오름차순
        while(iteratorKey.hasNext()){
            String key = iteratorKey.next();
            String start = key.split(":")[0];
            String destination = key.split(":")[1];

            // 현재 도시X && 다음 도시에 방문가능 여부 체크
            if(curCity.equals(start) && mapObj.get(curCity) != null && mapObj.get(curCity).contains(destination)){
                String nextCity = destination;

                if(tickedUsedChk.get(curCity+":"+destination) > 0) {
                    tickedUsedChk.put(curCity+":"+destination, tickedUsedChk.get(curCity+":"+destination) - 1);
                    curIdx++;
                    dfs(nextCity,tickedUsedChk, route, curIdx);
                    curIdx--;
                    tickedUsedChk.put(curCity+":"+destination, tickedUsedChk.get(curCity+":"+destination) + 1);
                }
            }
        }
    }

    private boolean chkFunc(TreeMap<String, Integer> tickedUsedChk, String[] route, int answerCnt){
        for(String key : tickedUsedChk.keySet()){
            if(tickedUsedChk.get(key).intValue() > 0) return false;
        }

        for(int i=0;i<answerCnt;i++){
            if(route[i] == null || "".equals(route[i])) return false;
        }

        return true;
    }
}