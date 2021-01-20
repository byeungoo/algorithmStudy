class Solution {
    public String solution(String p) {
        String answer = "";
        answer = recursive(p);

        return answer;
    }

    public String recursive(String s){

        // 2. p 에 대한 u(균형o, 최소), v로 분리
        int open = 0;
        int close = 0;
        String u = "";
        String v = "";

        for (int i = 0; i < s.length(); i++) {
            if ('(' == s.charAt(i)) open++;
            else if (')' == s.charAt(i)) close++;

            if (open == close) {
                u = s.substring(0, i + 1);
                v = s.substring(i + 1, s.length());
                break;
            }
        }

        // 3.
        StringBuilder sb = new StringBuilder();

        if(!isOk(u)){
            sb.append("(");
            sb.append(recursive(v));
            sb.append(")");

            for (int i = 1; i < u.length() - 1; i++) {
                if (u.charAt(i) == '(') sb.append(")");
                else sb.append("(");
            }
        }else{
            sb.append(u);
            if(!"".equals(v)) {
                sb.append(recursive(v));
            }
        }

        return sb.toString();
    }

    public boolean isOk(String s){
        boolean flag = true;
        int cur=0;

        for(int i=0;i<s.length();i++){
            if ('(' == s.charAt(i)) cur++;
            else cur--;

            if(cur < 0){
                flag = false;
                break;
            }
        }

        return flag;
    }
}