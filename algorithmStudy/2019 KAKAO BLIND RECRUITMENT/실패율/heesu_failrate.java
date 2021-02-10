import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] solution(String[] record) {
        String[] answer;

        Map<String, String> uidMap = new HashMap<>(); // uid - nickname map
        List<History> historyList = new ArrayList<>();


        for(int i=0;i<record.length;i++){
            String[] cmd = record[i].split(" ");

            String action = cmd[0];
            String uid = cmd[1];
            String nickname = "";

            if("Enter".equals(action)){
                nickname = cmd[2];
                uidMap.put(uid, nickname);
                historyList.add(new History(uid, "IN"));
            }else if("Leave".equals(action)){
                historyList.add(new History(uid, "OUT"));
            }else if("Change".equals(action)){
                nickname = cmd[2];

                // uidMap에서 닉네임변경
                uidMap.put(uid, nickname);
            }
        }

        answer = new String[historyList.size()];
        for(int i=0;i<historyList.size();i++){
            History curHist = historyList.get(i);
            String histStr = "";
            if("IN".equals(curHist.action)){
                histStr = uidMap.get(curHist.uid) + "님이 들어왔습니다.";
            }else if("OUT".equals(curHist.action)){
                histStr = uidMap.get(curHist.uid) + "님이 나갔습니다.";
            }

            answer[i] = histStr;
        }

        return answer;
    }
}

class History{
    public String uid;
    public String action; // IN, OUT

    public History(String _uid, String _action){
        uid = _uid;
        action = _action;
    }
}