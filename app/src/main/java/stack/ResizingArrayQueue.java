package stack;

import androidx.annotation.NonNull;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ResizingArrayQueue<T> implements Iterable<T> {

    private static final int INIT_CAPACITY = 8;
    private T[] item;
    private int n;
    private int first;
    private int last;

    public ResizingArrayQueue() {
        item = (T[]) new Object[INIT_CAPACITY];
        n = 0;
        first = 0;
        last = 0;
    }

    @NonNull
    @Override
    public Iterator<T> iterator() {
        return null;
    }

    public void enqueue(T t){
        if(n == item.length)
            resize(2*item.length);
        item[last++] = t;
        n++;
    }

    public T dequeue(){
        T t = item[first];
        item[first] = null;
        n--;
        first++;
        if (n > 0 && n == item.length/4)
            resize(item.length/2);
        return t;
    }

    public int length(){
        return n;
    }

    public void resize(int length){
        assert length >= n;
        T[] newItem = (T[]) new Object[length];
        for(int i=0;i<n;i++){
            newItem[i] = item[(first+i) % item.length];
        }
        item = newItem;
        first = 0;
        last  = n;
    }

    public static void main(String[] args) {
        ResizingArrayQueue<String> queue = new ResizingArrayQueue<>();
        for (int i=0;i<10;i++){
            queue.enqueue(i+"");
        }
        for (int i=0;i<10;i++){
            System.out.println(queue.dequeue());
        }
    }
}
