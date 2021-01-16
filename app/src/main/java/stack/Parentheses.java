package stack;

import java.util.Stack;

public class Parentheses {

    private static String base = "[()]{}{[()()]()}";
    private static final char Left_Paren = '(';
    private static final char Right_Paren = ')';
    private static final char Left_Brace = '}';
    private static final char Right_Brace = '}';
    private static final char Left_Bracket = '[';
    private static final char Right_Bracket = ']';

    public static void main(String[] args) {
        System.out.println(isBalanced(base));
        String str = "123";
        getString(str);
    }

    public static void getString(String info){
        info = "12312321";
    }

    public static boolean isBalanced(String str){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i<str.length(); i++){
            if(str.charAt(i) == Left_Paren)
                stack.push(Left_Paren);
            if(str.charAt(i) == Left_Brace)
                stack.push(Left_Brace);
            if(str.charAt(i) == Left_Bracket)
                stack.push(Left_Bracket);
            if(str.charAt(i) == Right_Paren){
                if(stack.isEmpty())
                    return false;
                if(stack.pop() != Left_Paren)
                    return false;
            }else if(str.charAt(i) == Right_Brace){
                if(stack.isEmpty())
                    return false;
                if(stack.pop() != Left_Brace)
                    return false;
            }else if(str.charAt(i) == Right_Bracket){
                if(stack.isEmpty())
                    return false;
                if(stack.pop() != Left_Bracket)
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
