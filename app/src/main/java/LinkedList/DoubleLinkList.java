package LinkedList;

public class DoubleLinkList {
 
    //头
    private DoubleNode first;
    //尾
    private DoubleNode last;
 
    public DoubleLinkList(){
        first = null;
        last = null;
    }
 
    /**
     * 插入数据
     * @param value
     */
    public void insertFirst(long value){
        DoubleNode newNode = new DoubleNode(value);
        if (first == null) {
            last = newNode;
        }else {
            first.pre = newNode;
            //把first节点往下移动
            newNode.next = first;
        }
        //把插入的节点作为新的节点
        first = newNode; 
    }
 
    /**
     * 插入数据
     * @param value
     */
    public void insertLast(long value){
        DoubleNode newNode = new DoubleNode(value);
        if (first == null) {
            first = newNode;
        }else {
            last.next = newNode;
            //first.pre = newNode;
            newNode.pre = last;
        }
        //把最后个节点设置为最新的节点
        last = newNode;
    }
 
    public boolean isEmpty(){
        return first == null;
    }
 
    /**
     * 删除头节点时要去除两个指针,一个指向下个的next ,一个是next的pre指向前面的
     * 
     * @param
     * @return
     */
    public DoubleNode deleteFirst(){
        if (first == null) {
            throw new RuntimeException("链表数据不存在");
        }
        DoubleNode temp = first;
        if (first.next == null) {
            last = null;
        }else {
            first.next.pre = null;
        }
        first = temp.next;
        return temp;
    }
 
    /**
     * 删除头节点时要去除两个指针,一个指向下个的next ,一个是next的pre指向前面的
     * 
     * @param
     * @return
     */
    public DoubleNode deleteLast(){
        if (first == null) {
            throw new RuntimeException("链表数据不存在");
        }
 
        DoubleNode temp = last;
        if (first.next == null) {
            last = null;
            //把第一个删除
            first = null;
        }else {
            last.pre.next = null;
        }
        last = temp.pre;
        return temp;
    }
 
    /**
     * 删除
     * @param key
     * @return
     */
    public DoubleNode deleteByKey(long key){
        DoubleNode current = first;
        while(current.data != key){
            if (current.next == null) {
                System.out.println("没找到节点");
                return null;
            }
            current = current.next;
        }
        if (current == first) {
            //return deleteFirst();
            //指向下个就表示删除第一个
            first = first.next;
        }else {
            current.pre.next = current.next;
        }
        return current;
    }
 
    /**
     * 显示所有的数据
     */
    public void display(){
        if (first == null) {
            //throw new RuntimeException("链表数据不存在");
            return;
        }
        DoubleNode current = first;
        while(current != null){
            //current.display();
            current = current.next;
        }
        System.out.println("---------------");
    }
 
    /**
     * 查找节点1
     * @param value
     * @return
     */
    public DoubleNode findByValue(long value){
        DoubleNode current = first;
        while(current != null){
            if (current.data != value) {
                current = current.next;
            }else {
                break;
            }
        }
        if (current == null) {
            System.out.println("没找到");
            return null;
        }
        return current;
    }
 
    /**
     * 查找节点2
     * 
     * @param key
     * @return
     */
    public DoubleNode findByKey(long key) {
        DoubleNode current = first;
        while (current.data != key) {
            if (current.next == null) {
                System.out.println("没找到");
                return null;
            }
            current = current.next;
        }
        return current;
    }
 
    /**
     * 根据索引查找对应的值
     * @param position
     * @return
     */
    public DoubleNode findByPosition(int position){
        DoubleNode current = first;
        //为什么是position - 1，因为要使用遍历，让current指向下一个， 所以position - 1的下个node就是要找的值
        for (int i = 0; i < position - 1 ; i++) {
            current  = current.next;
        }
        return current;
    }
 
 
    public static void main(String[] args) {
        DoubleLinkList linkList = new DoubleLinkList();
        linkList.insertFirst(21);
        linkList.insertFirst(22);
        linkList.insertFirst(23);
        linkList.insertLast(24);
        linkList.insertLast(25);
        linkList.insertLast(26);
        linkList.insertLast(27);
 
        linkList.display();
 
        System.out.println("---查找-------------------------------------");
 
        linkList.findByKey(25);
 
        System.out.println("--删除first-------------------------------------");
 
        //linkList.deleteFirst().display();
        ///linkList.deleteFirst().display();
        //linkList.deleteFirst().display();
        //linkList.deleteFirst().display();
 
        System.out.println("-删除指定值---------------------------------------");
        linkList.deleteByKey(27);
        linkList.deleteByKey(21);
 
        System.out.println("----------------------------------------");
        linkList.display();
 
 
    }
}
 