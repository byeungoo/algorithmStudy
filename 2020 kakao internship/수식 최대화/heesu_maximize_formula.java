import java.util.HashSet;
import java.util.LinkedList;
import static java.lang.Math.abs;

class Solution {
    long answer = 0;
    public long solution(String expression) {
        HashSet<Character> ops = new HashSet<>();
        LinkedList<Character> expOps = new LinkedList<>();
        LinkedList<Long> nums = new LinkedList<>();

        // 연산자 셋팅
        for(int i=0 ;i< expression.length();i++) {
            if (expression.charAt(i) < 48) {
                expOps.add(expression.charAt(i));
                ops.add(expression.charAt(i));
            }
        }

        // 숫자 셋팅
        String[] numArr = expression.split("\\+|-|\\*");
        for(int i=0;i<numArr.length;i++){
            nums.add(Long.parseLong(numArr[i]));
        }

        perm(ops.toArray(new Character[ops.size()]), 0, ops.size(), expOps, nums);

        return answer;
    }
    void perm(Character[] ops, int depth, int n, LinkedList<Character> expOps, LinkedList<Long> nums){
        if(depth == n-1){
            LinkedList<Long> tgtNums = new LinkedList<>();
            LinkedList<Character> tgtExpOps = new LinkedList<>();
            tgtNums.addAll(nums);
            tgtExpOps.addAll(expOps);

            // 계산 ( perm()에서 구한 연산자 우선순위별iterate)
            for(int i=0;i<ops.length;i++){
                eval(tgtNums, tgtExpOps, ops[i].charValue());
            }

            if(abs(tgtNums.get(0).longValue()) > answer) answer = abs(tgtNums.get(0).longValue());

        }
        for(int i=depth;i<n;i++){
            char tmp = ops[depth];
            ops[depth] = ops[i];
            ops[i] = tmp;

            perm(ops, depth+1, n, expOps, nums);

            tmp = ops[depth];
            ops[depth] = ops[i];
            ops[i] = tmp;
        }
    }

    void eval(LinkedList<Long> nums, LinkedList<Character> expOps, char tgtOp){
        /*
            expOps 순서대로 돌면서 현재 우선순위 연산에 대한 연산부터 시작
         */
        int cur = 0 ;
        while(expOps.size() > cur){
            if(tgtOp == expOps.get(cur)){
                long result = Long.MAX_VALUE;

                if(tgtOp == '+'){
                    result = nums.get(cur) + nums.get(cur+1);
                }else if(tgtOp == '-'){
                    result = nums.get(cur) - nums.get(cur+1);
                }else if(tgtOp == '*'){
                    result = nums.get(cur) * nums.get(cur+1);
                }

                nums.remove(cur);
                nums.add(cur, result);
                nums.remove(cur+1);

                expOps.remove(cur);
                cur--;
            }
            cur++;
        }
    }
}