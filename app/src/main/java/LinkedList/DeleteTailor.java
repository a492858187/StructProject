package LinkedList;

import android.text.TextUtils;

public class DeleteTailor {
    public static void main(String[] args) {
        Node link = initLinkedList();

        //deleteTailor(link);

        //deleteWithPosition(link,5);

        //System.out.println(find(link,"end"));

        //Node delNode = new Node();
        //delNode.data = "2";
        //removeAfter(link,delNode);

//        Node firstNode = new Node();
//        firstNode.data = "2";
//        Node secondNode = new Node();
//        secondNode.data = "4";
//        insertAfter(link,firstNode,secondNode);

        //remove(link,"2");

        //max(link);
        //max2(link);

        //reverse1(link);
        reverse2(link);
    }

    //初始化链表
    public static Node initLinkedList(){
        Node first = new Node();
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        first.data = "first";
        node1.data = "1";
        node2.data = "2";
        node3.data = "3";
        node4.data = "4";
        first.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        return first;
    }

    //删除链表最后一个节点
    private static void deleteTailor(Node link){
        if(link != null) {
            Node head = link;
            Node pre = link;
            while (head.next != null) {
                pre = head;
                head = head.next;
            }
            pre.next = null;
        }
    }

    //删除第k个位置元素
    private static void deleteWithPosition(Node link,int k){
        if(link != null && k>0) {
            Node head = link;
            Node pre = link;
            for(int i=1;i<k;i++){
                if(head.next == null)
                    break;
                pre = head;
                head = head.next;
            }
            pre.next = head.next;
        }
    }

    //查找链表是否有该值
    private static boolean find(Node link,String key){
        boolean isFind = false;
        if(link != null && key != null) {
            Node head = link;
            while (head.next != null){
                if(key.equals(head.data))
                    isFind = true;
                head = head.next;
            }
        }
        return isFind;
    }

    //移除指定节点的后续节点
    private static void removeAfter(Node link,Node delNode){
        if(link != null && delNode != null) {
            Node head = link;
            while (head.next != null){
                if(delNode.data.equals(head.data))
                    head.next = head.next.next;
                else
                    head = head.next;
            }
        }
    }

    //将节点插入成为指定节点的后续节点
    private static void insertAfter(Node link,Node key,Node insert){
        if(link != null && key != null && insert != null) {
            Node head = link;
            while (head.next != null){
                if(key.data.equals(head.data)) {
                    insert.next = head.next;
                    head.next = insert;
                    break;
                }
                head = head.next;
            }
        }
    }

    //删除链表中所有值为key的节点
    private static void remove(Node link,String key){
        if(link != null && key != null) {
            Node head = link;
            while (head.next != null){
                if(key.equals(head.next.data)){
                    head.next = head.next.next;
                }else
                    head = head.next;
            }
        }
    }

    //返回链表中值最大的节点
    private static String max(Node link){
        String max = "";
        if(link != null){
            Node head = link;
            while (head.next != null){
                if(head.data.compareTo(head.next.data)>0){
                    max = head.data;
                }else
                    max = head.next.data;
                head = head.next;
            }
        }
        return max;
    }

    //返回链表中值最大的节点(递归)
    static String max = "";
    private static String max2(Node link){
        if(link != null){
            Node head = link;
            if(head.next != null) {
                if (head.data.compareTo(head.next.data) > 0) {
                    max = head.data;
                } else
                    max = head.next.data;
                head = head.next;
                max2(head);
            }
        }
        return max;
    }

    //链表反转
    private static void reverse1(Node link){
        if(link != null){
            Node first = link;
            Node reverse = null;
            while (first != null){
                Node second = first.next;
                first.next = reverse;
                reverse = first;
                first = second;
            }
        }
    }

    //链表反转(递归)
    private static Node reverse2(Node link){
        if (link == null) return null;
        if (link.next == null) return link;

        Node first = link;
        Node second = first.next;
        Node reverse = reverse2(second);
        second.next = first;
        first.next = null;
        return reverse;

    }
}
