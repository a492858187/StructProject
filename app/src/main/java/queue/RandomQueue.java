package queue;

import java.util.Iterator;
import java.util.Random;

//随机队列
public class RandomQueue<Item> implements Iterable<Item> {

    private Item[] items;
    private int N;

    public RandomQueue() {
        items = (Item[]) new Object[1];
        N = 0;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void enqueue(Item item){
        if(N == items.length)
            resize(N*2);
        items[N++] = item;
    }

    public Item dequeue(){
        randSwap();
        Item item = items[N-1];
        items[N-1] = null;
        N--;
        if (N > 0 && N == items.length / 4)
            resize(items.length / 2);
        return item;
    }

    public void randSwap(){
        if(N<1) return;
        Random random = new Random();
        int swap = random.nextInt(N-1);
        Item temp = items[N-1];
        items[N-1] = items[swap];
        items[swap] = temp;
    }

    public void resize(int length){
        Item[] newItems = (Item[]) new Object[length];
        for (int i=0;i<N;i++){
            newItems[i] = items[i];
        }
        items = newItems;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    public static void main(String[] args) {
        RandomQueue<String> queue = new RandomQueue<>();
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
    }
}
