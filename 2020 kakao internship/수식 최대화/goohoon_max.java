/*
 * 풀이시간: 1시간 20분
*/

import java.util.*;

class Solution {
   
    static long answer = -1;
    
    public static Long solution(String expression) {


        List<String> list = new ArrayList<>();

        //1. list에 나눠서 담음
        initList(expression, list);

        System.out.println("list : " + list);

        //2. 연산자 우선순위 별로 우승상금 계산(최대 6가지)
        String[] orders = {"*", "+", "-"};
        calculate(orders, list);
        
        orders = new String[]{"*", "-", "+"};
        calculate(orders, list);
        
        orders = new String[]{"+", "*", "-"};
        calculate(orders, list);

        orders = new String[]{"+", "-", "*"};
        calculate(orders, list);
        
        orders = new String[]{"-", "+", "*"};
        calculate(orders, list);

        orders = new String[]{"-", "*", "+"};
        calculate(orders, list);

        return answer;
    }
    
    private static void calculate(String[] orders, List<String> list){
        List<String> copyList = new ArrayList<>();
        copyList.addAll(list);
        for(int i=0;i<orders.length;i++){
            if("*".equals(orders[i]))
                multiply(copyList);
            else if("+".equals(orders[i]))
                add(copyList);
            else if("-".equals(orders[i]))
                minus(copyList);            
        }        
        
        answer = Math.abs(Long.parseLong(copyList.get(0))) > answer ?  Math.abs(Long.parseLong(copyList.get(0))) : answer;
    }

    private static void initList(String expression, List<String> list) {
        String n = "";
        for(int i=0;i<expression.length();i++){
            char c = expression.charAt(i);

            if(c == '*' || c == '-' || c == '+'){
                list.add(n);
                list.add(String.valueOf(c));
                n = "";
            } else if(i == expression.length()-1){
                n += String.valueOf(c);
                list.add(n);
            } else{
                n += String.valueOf(c);
            }
        }
    }

    public static void multiply(List<String> list){
        while(list.contains("*")){

            int i = list.indexOf("*");
            Long  num1 = Long.parseLong(list.get(i-1));
            Long  num2 = Long.parseLong(list.get(i+1));
            Long result = num1 * num2;
            list.remove(i+1);
            list.set(i, String.valueOf(result));
            list.remove(i-1);
        }

    }

    public static void add(List<String> list){
        while(list.contains("+")){

            int i = list.indexOf("+");
            Long num1 = Long.parseLong(list.get(i-1));
            Long num2 = Long.parseLong(list.get(i+1));
            Long result = num1 + num2;
            list.remove(i+1);
            list.set(i, String.valueOf(result));
            list.remove(i-1);
        }

    }

    public static void minus(List<String> list){
        while(list.contains("-")){

            int i = list.indexOf("-");
            long  num1 = Long.parseLong(list.get(i-1));
            long  num2 = Long.parseLong(list.get(i+1));
            long  result = num1 - num2;
            list.remove(i+1);
            list.set(i, String.valueOf(result));
            list.remove(i-1);
        }

    }
}