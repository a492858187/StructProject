package stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CopyStack<Item> implements Iterable<Item> {
    private Node<Item> first;
    private int n;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;

        Node(){}

        Node(Node x) {
            this.item = (Item) x.item;
            this.next = x.next;
        }
    }

    public CopyStack(CopyStack copyStack){
        if (copyStack.first != null) {
            first = new Node(copyStack.first);
            for (Node x = first; x.next != null; x = x.next)
                x.next = new Node(x.next);
        }
    }

    public CopyStack() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void push(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.item;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }


    public Iterator<Item> iterator() {
        return new LinkedIterator(first);
    }

    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current;

        public LinkedIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        CopyStack<String> stack = new CopyStack<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");
        stack.push("6");
        Iterator<String> iterator = stack.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        CopyStack<String> stack2 = new CopyStack<>(stack);
        Iterator<String> iterator2 = stack2.iterator();
        while (iterator2.hasNext()){
            System.out.println(iterator2.next());
        }
    }
}
