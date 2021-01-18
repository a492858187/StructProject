package LinkedList;

//前移编码
public class MoveToFont<Item> {

    private Node first;
    private Node last;

    public class Node{
        public Node next;
        public Item data;
    }

    void put(Item e){
        Node newNode = new Node();
        newNode.data = e;
        if(first == null){
            last = newNode;
        }else {
            Node current = first;
            while (current.next != null){
                if(e.equals(current.next.data)){
                    current.next = current.next.next;
                    break;
                }
                current = current.next;
            }
            newNode.next = first;
        }
        first = newNode;
    }

    public static void main(String[] args) {
        MoveToFont<String> move = new MoveToFont<>();
        move.put("1");
        move.put("2");
        move.put("3");
        move.put("4");
        move.put("3");
        move.put("2");
    }
}
