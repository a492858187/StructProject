package stack;

import java.util.Stack;

public class Buffer {
    Stack<Character> left = new Stack<Character>();
    Stack<Character> right = new Stack<Character>();
    public int size()
    {
        return left.size() + right.size();
    }
    public void insert(char c)
    {
        left.push(c);
    }
    public char delete()
    {
        return left.pop();
    }
    public void left(int k)
    {
        if(k>left.size()) return;
        for (int i = 0; i < k; i++)
            right.push(left.pop());
    }
    public void right(int k)
    {
        if(k>right.size()) return;
        for (int i = 0; i < k; i++)
            left.push(right.pop());
    }

    public static void main(String[] args)
    {
        Buffer e = new Buffer();
        String str = "photoggrph";
        for (int i = 0; i < str.length(); i++)
            e.insert(str.charAt(i));

        e.left(4);
        e.delete();
        e.right(2);
        e.insert('a');
        e.right(2);
        for(Character c:e.left)
            System.out.print(c+" ");
        for(Character c:e.right)
            System.out.print(c+" ");
    }

}
