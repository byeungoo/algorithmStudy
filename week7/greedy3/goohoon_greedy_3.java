class Solution {
    
    public int solution(String name) {
        int answer = 0;
        
        //알파벳 조작 최소 횟수
        for(int i=0;i<name.length();i++){
            answer += Math.min(name.charAt(i)-'A', 'Z' - name.charAt(i) +1);   
        }
        
        //이동 최대 길이
        int minMove = name.length() - 1;
        for(int i = 0 ; i < name.length() ; i++) {
            if(name.charAt(i) != 'A') {
                int next = i+1;
                while(next < name.length() && name.charAt(next) == 'A') {
                    next++;
                }

                //왔던 길이(i)만큼 돌아감 2i 
                //연속되는 A를 제외하고 현재온길이와 A를 더한길이를 빼주면 나머지 이동길이가 나옴
                minMove = Math.min(minMove, 2*i+name.length()-next);
                System.out.println("i : " + i + ", minMove : " + minMove);
            }
        }
        
        answer += minMove;
        
        return answer;
    }
}