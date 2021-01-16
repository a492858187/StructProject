package LinkedList;

public class DoubleNode {
    public DoubleNode pre;
    public DoubleNode next;
    public long data;

    public DoubleNode(long data) {
        this.data = data;
    }

    public DoubleNode getPre() {
        return pre;
    }

    public void setPre(DoubleNode pre) {
        this.pre = pre;
    }

    public DoubleNode getNext() {
        return next;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }

    public long getData() {
        return data;
    }

    public void setData(long data) {
        this.data = data;
    }
}
