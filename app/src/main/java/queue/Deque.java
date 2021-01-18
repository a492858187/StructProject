package queue;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
/**
 * boolean isEmpty()            是否为空
 * int size()                   元素数量
 * void pushLeft(Item item)     向左端添加一个新元素
 * void pushRight(Item item)    向右端添加一个新元素
 * Item popLeft()               从左端删除一个元素
 * Item popRight()              从右端删除一个元素
 */
//使用双向链表实现双向队列
public class Deque<Item> implements Iterable<Item> {

    private DoubleNode first;
    private DoubleNode last;
    private int N;

    public class DoubleNode{
        public DoubleNode pre;
        public DoubleNode next;
        public Item data;
    }

    boolean isEmpty(){
        return N == 0;
    }

    int size(){
        return N;
    }

    void pushLeft(Item item){
        DoubleNode newNode = new DoubleNode();
        newNode.data = item;
        if(first == null){
            last = newNode;
        }else {
            first.pre = newNode;
            newNode.next = first;
        }
        first = newNode;
        N++;
    }

    void pushRight(Item item){
        DoubleNode newNode = new DoubleNode();
        newNode.data = item;
        if(last == null){
            first = newNode;
        }else {
            last.next = newNode;
            newNode.pre = last;
        }
        last = newNode;
        N++;
    }

    Item popLeft(){
        if (N != 0) N--;
        if(first != null) {
            Item item = first.data;
            first = first.next;
            return item;
        }else {
            first = null;
            last = null;
            return null;
        }
    }

    Item popRight(){
        if (N != 0) N--;
        if(last != null) {
            Item item = last.data;
            last.next = null;
            last = last.pre;
            return item;
        }else {
            first = null;
            last = null;
            return null;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<Item>{

        private DoubleNode current = first;
        private int count=size();

        @Override
        public boolean hasNext() {
            if(count != size())
                throw new ConcurrentModificationException("Deque was being modified!");
            return current != null;
        }

        @Override
        public Item next() {
            if(count != size())
                throw new ConcurrentModificationException("Deque was being modified!");
            Item item = current.data;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Deque<String> deque = new Deque<>();
        deque.pushLeft("1");
        deque.pushLeft("2");
        deque.pushLeft("3");

        deque.pushRight("4");
        deque.pushRight("5");
        deque.pushRight("6");

        System.out.println("队列大小："+deque.size());

        deque.popLeft();
        deque.popLeft();
        deque.popLeft();
        deque.popLeft();
        deque.popLeft();
        deque.popLeft();
        deque.popLeft();
        deque.popLeft();

        System.out.println("左出队后队列大小："+deque.size());

//        deque.popRight();
//        deque.popRight();
//        deque.popRight();
//        deque.popRight();
//        deque.popRight();
//        deque.popRight();
//        deque.popRight();
//        deque.popRight();
//        System.out.println("右出队后队列大小："+deque.size());

        Iterator<String> iterator = deque.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
