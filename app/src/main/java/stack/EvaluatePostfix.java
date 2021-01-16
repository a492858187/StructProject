package stack;

import java.util.Stack;

public class EvaluatePostfix {

    //1+(2*((3+(4*5))*6))
    private static String base = "12345*+6**+";

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<base.length();i++) {
            String str = String.valueOf(base.charAt(i));
            if(str.equals("+")){
                stack.push(stack.pop() + stack.pop());
            }else if(str.equals("*")){
                stack.push(stack.pop() * stack.pop());
            }else
                stack.push(Integer.parseInt(str));
        }
        System.out.println(stack.pop());
    }
}
