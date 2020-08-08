import java.util.*;

class Solution {
    
    boolean[] visit;
    List<String> list = new ArrayList<>();
    
    public void dfs(String[][] tickets, String preDesti, String route, int depth) {
        
        route += preDesti + ",";
        
        if(depth == tickets.length){
            list.add(route);
            return;
        }
        
		for(int i = 0 ; i < tickets.length ; i++) {
			String depart = tickets[i][0];
			String desti = tickets[i][1];
			
			if(preDesti.equals(depart) && !visit[i]) {
				visit[i] = true;
				dfs(tickets, desti, route, depth+1);
				visit[i] = false;
			}
		}        
        
    }

    public String[] solution(String[][] tickets) {
        String[] answer = {};
        int len = tickets.length;
        visit = new boolean[len];
        String route = "";
        
		for(int i = 0 ; i < len; i++) {
			String depart = tickets[i][0];
			String desti  = tickets[i][1];
			
			if(depart.equals("ICN")) {
				visit[i] = true;
				route = depart + ",";
				dfs(tickets, desti, route, 1);
				visit[i] = false;
			}
		}        
        
        Collections.sort(list);
        answer = list.get(0).split(",");
        
        for(int i=0;i<answer.length;i++){
            System.out.println(answer[i]);
        }
        
        return answer;
    }
}