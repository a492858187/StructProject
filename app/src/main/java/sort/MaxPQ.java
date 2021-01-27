package sort;

//基于堆的优先队列
public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N = 0;

    public MaxPQ(int maxN){
        pq = (Key[]) new Comparable[maxN+1];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void insert(Key v){
        pq[++N] = v;
        swim(N);
    }

    public void insertSort(Key v){
        pq[++N] = v;
        //swim(N);
    }

    public Key delMax(){
        Key max = pq[1];
        swap(pq,1,N--);
        pq[N+1] = null;
        sink(1);
        return max;
    }

    public void sort(){
        for (int k = N/2; k>=1; k--){
            sink(k);
        }
        while (N > 1){
            //排序，把最大的数放到末尾
            swap(pq,1,N--);
            //由于破坏了堆的有序性，需要重新排列，0~N--
            sink(1);
        }
    }

    public void swim(int k){
        while (k > 1 && less(pq[k/2],pq[k])){
            swap(pq,k/2,k);
            k = k/2;
        }
    }

    public void sink(int k){
        while (2*k <= N){
            int j = 2*k;
            if(j < N && less(pq[j],pq[j+1]))
                j++;
            if(!less(pq[k],pq[j]))
                break;
            swap(pq,k,j);
            k = j;
        }
    }

    public boolean less(Key a,Key b){
        return a.compareTo(b) < 0;
    }

    public void swap(Key[] arrays,int a,int b) {
        Key temp = arrays[a];
        arrays[a] = arrays[b];
        arrays[b] = temp;
    }

    public static void main(String[] args) {
        MaxPQ<Integer> maxPQ = new MaxPQ<>(10);
//        maxPQ.insert(5);
//        maxPQ.insert(2);
//        maxPQ.insert(3);
//        maxPQ.insert(1);
//        maxPQ.insert(4);
//        maxPQ.insert(6);
//        maxPQ.insert(7);
//        maxPQ.insert(8);

        maxPQ.insertSort(5);
        maxPQ.insertSort(2);
        maxPQ.insertSort(3);
        maxPQ.insertSort(1);
        maxPQ.insertSort(4);
        maxPQ.insertSort(6);
        maxPQ.insertSort(7);
        maxPQ.insertSort(8);
        maxPQ.sort();
        //maxPQ.delMax();
        //maxPQ.delMax();
    }
}
