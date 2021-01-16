package stack;

import java.util.Stack;

public class InfixToPostfix {
    //private static String base = "(2+((3+4)*(5*6)))";
    private static String base = "(1+(2*((3+(4*5))*6)))";

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        for (int i=0;i<base.length();i++){
            String str = String.valueOf(base.charAt(i));
            if(str.equals("+"))
                stack.push(str);
            else if(str.equals("*"))
                stack.push(str);
            else if(str.equals(")"))
                System.out.print(stack.pop() + "");
            else if(str.equals("("))
                System.out.print("");
            else
                System.out.print(str);
        }
    }

}
