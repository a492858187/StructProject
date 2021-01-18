package queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//随机队列
public class Josephus{

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int m, n;
//        m = sc.nextInt();
//        n = sc.nextInt();
//        pass(m, n);    //  注意这里的m为传递次数，要与报数次数区分开.即：传递次数 = 报数次数-1.
        //pass(7, 0, 2);

        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);

        // initialize the queue
//        Queue<Integer> queue = new Queue<Integer>();
//        for (int i = 0; i < n; i++)
//            queue.enqueue(i);
//
//        while (!queue.isEmpty()) {
//            for (int i = 0; i < m-1; i++)
//                queue.enqueue(queue.dequeue());
//            //StdOut.print(queue.dequeue() + " ");
//        }
        //StdOut.println();
    }

    public static void pass(int number,int start,int distance)
    {
        List<String> list=new ArrayList<String>(number);
        for(int i=0;i<number;i++){
            list.add((char)('A'+i)+"");
        }
        System.out.print("约瑟夫环("+number+","+start+","+distance+"),");
        System.out.println(list.toString());
        int i=start;
        while(list.size()>1){
            i=(i+distance-1)%list.size();
            System.out.print("删除的元素："+list.remove(i).toString()+",位置为："+i);
            System.out.println(list.toString());
        }
        System.out.println("被赦免的罪犯是："+list.get(0).toString());

    }
}
