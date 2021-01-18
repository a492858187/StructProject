package queue;

import java.util.LinkedList;
import java.util.Queue;

//两个队列实现栈
public class StackQueue<Item> {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    public StackQueue() {
    }

    public boolean push(Integer num) {
        return q1.offer(num);
    }

    public Integer pop() {
        if (q1.isEmpty() && q2.isEmpty()) {
            return null;
        }
        // 先判断 q1 是否为空
        if (!q1.isEmpty()) {
            int size = q1.size();
            for (int i = 0; i < size - 1; i++) {
                q2.offer(q1.poll());
            }
            return q1.poll();
        } else {
            int size = q2.size();
            for (int i = 0; i < size - 1; i++) {
                q1.offer(q2.poll());
            }
            return q2.poll();
        }
    }

    public Integer size() {
        return q1.size() + q2.size();
    }


    public static void main(String[] args) {
        StackQueue stack = new StackQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        int size = stack.size();
        for (int i = 0; i < size; i++) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
        stack.push(6);
        System.out.println(stack.pop());
    }
}
