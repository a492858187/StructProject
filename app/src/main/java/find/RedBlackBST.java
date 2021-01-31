package find;

//红黑树
public class RedBlackBST<Key extends Comparable<Key>,Value> {

    private Node root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node{
        Key key;
        Value val;
        Node left,right;
        int N;
        boolean color;

        public Node(Key key, Value val, int n, boolean color) {
            this.key = key;
            this.val = val;
            N = n;
            this.color = color;
        }
    }

    public int size(){
        return size(root);
    }

    public int size(Node x){
        if(x == null)
            return 0;
        return x.N;
    }

    private boolean isRed(Node x){
        if(x == null)
            return false;
        return x.color == RED;
    }

    private Node rotateLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color= h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    private Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    private void flipColors(Node h){
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public void put(Key key,Value val){
        root = put(root,key,val);
        root.color = BLACK;
    }

    public Node put(Node h,Key key,Value val){
        if(h == null)
            return new Node(key,val,1,RED);
        int cmp = key.compareTo(h.key);
        if(cmp < 0)
            h.left = put(h.left,key,val);
        else if(cmp > 0)
            h.right = put(h.right,key,val);
        else
            h.val = val;
        if(isRed(h.right) && !isRed(h.left))
            h = rotateLeft(h);
        if(isRed(h.left) && isRed(h.left.left))
            h = rotateRight(h);
        if(isRed(h.left) && isRed(h.right))
            flipColors(h);
        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

    public static void main(String[] args) {
        RedBlackBST<String,Integer> redBlackBST = new RedBlackBST<>();
        redBlackBST.put("S",1);
        redBlackBST.put("E",2);
        redBlackBST.put("A",3);
        redBlackBST.put("R",4);
        redBlackBST.put("C",5);
        redBlackBST.put("H",6);
        redBlackBST.put("X",7);
        redBlackBST.put("M",8);
        redBlackBST.put("P",9);
        redBlackBST.put("L",10);
    }
}
