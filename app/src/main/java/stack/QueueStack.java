package stack;

import java.util.Stack;

//两个栈实现队列
public class QueueStack<Item> {
    private Stack<Item> s = new Stack<Item>();
    private Stack<Item> st = new Stack<Item>();

    public boolean isEmpty() {
        return st.isEmpty() && s.isEmpty();
    }

    public int size() {
        return st.size() + s.size();
    }

    void enqueue(Item item){
        s.push(item);
    }

    Item dequeue(){
        if(st.isEmpty()) {  //非空即满
            while(!s.isEmpty()) {
                st.push(s.pop());
            }
        }
        return st.pop();
    }

    public static void main(String[] args) {
        QueueStack<String> queueStack = new QueueStack<>();
        queueStack.enqueue("1");
        queueStack.enqueue("2");
        queueStack.enqueue("3");
        queueStack.enqueue("4");

        System.out.println(queueStack.dequeue());

        queueStack.enqueue("5");

        System.out.println(queueStack.dequeue());
    }
}
