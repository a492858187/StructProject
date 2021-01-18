package queue;

//一个以栈为目标的队列

import androidx.annotation.NonNull;

import java.util.Iterator;

import LinkedList.Node;

/**
 * boolean isEmpty()
 * void push(Item e)            添加一个元素到头部
 * Item pop()                   从头部删除一个元素
 * void enqueue(Item e)         添加一个元素到尾部
 */
public class Steque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;

    public class Node
    {
        public Item data;
        public Node next;
    }

    boolean isEmpty(){
        return first == null;
    }

    //入队
    void enqueue(Item e){
        Node newNode = new Node();
        newNode.data = e;
        newNode.next = null;
        if(first == null){
            first = newNode;
        }else {
            last.next = newNode;
        }
        last = newNode;
    }

    //入栈
    void push(Item e){
        Node newNode = new Node();
        newNode.data = e;
        newNode.next = null;
        if(first == null){
            last = newNode;
        }else {
            newNode.next = first;
        }
        first = newNode;
    }

    //出队
    Item pop(){
        if(first == null){
            return null;
        }else {
            Item item = first.data;
            first = first.next;
            return item;
        }
    }

    //连接
    void catenate(Steque<Item> steque){
        for (Item item : steque){
            enqueue(item);
        }
    }

    @NonNull
    @Override
    public Iterator<Item> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<Item>{

        private Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.data;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Steque<String> steque = new Steque<>();
        steque.push("1");
        steque.push("2");
        steque.push("3");
        steque.enqueue("6");
        steque.enqueue("5");
        steque.enqueue("4");

        Steque<String> steque1 = new Steque<>();
        steque1.push("a");
        steque1.push("b");
        steque1.push("c");
        steque1.enqueue("d");
        steque1.enqueue("e");
        steque1.enqueue("f");

        steque.catenate(steque1);

        Iterator<String> iterator = steque.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
//        steque.pop();
//        steque.pop();
//        steque.pop();
    }
}
