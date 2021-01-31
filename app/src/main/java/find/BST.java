package find;

import java.util.LinkedList;

public class BST<Key extends Comparable<Key>,Value> {

    private Node root;

    private class Node{
        private Key key;
        private Value val;
        private Node left,right;
        private int N;

        public Node(Key key, Value val, int n) {
            this.key = key;
            this.val = val;
            N = n;
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

    public Value get(Key key){
        return get(root,key);
    }

    public Value get(Node x,Key key){
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0)
            return get(x.left,key);
        else if(cmp > 0)
            return get(x.right,key);
        else
            return x.val;
    }

    public void put(Key key,Value val){
        root = put(root,key,val);
    }

    public Node put(Node x,Key key,Value val){
        if(x == null)
            return new Node(key,val,1);
        int cmp = key.compareTo(x.key);
        if(cmp < 0)
            x.left = put(x.left,key,val);   //生成左子节点并赋值
        else if(cmp > 0)
            x.right = put(x.right,key,val); //生成右子节点并赋值
        else
            x.val = val;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key min(){
        return min(root).key;
    }

    public Node min(Node x){
        if(x.left == null)
            return x;
        return min(x.left);
    }

    public Key max(){
        return max(root).key;
    }

    public Node max(Node x){
        if(x.right == null)
            return x;
        return min(x.right);
    }

    public Key floor(Key key){
        Node x = floor(root,key);
        if(x == null)
            return null;
        return x.key;
    }

    public Node floor(Node x,Key key){
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if(cmp == 0) return x;
        else if(cmp < 0)
            return floor(x.left,key);
        Node n = floor(x.right,key);
        if(n != null)
            return n;
        else
            return x;
    }

    public Key select(int k){
        return select(root,k).key;
    }

    public Node select(Node x,int k){
        if(x == null) return null;
        int t = size(x.left);
        if(k < t)
            return select(x.left,k);
        else if(k > t)
            return select(x.right,k - t - 1);
        else
            return x;
    }

    public int rank(Key key){
        return rank(root,key);
    }

    public int rank(Node x,Key key){
        if(x == null) return 0;
        int cmp = key.compareTo(x.key);
        if(cmp < 0)
            return rank(x.left,key);
        else if(cmp > 0)
            return rank(x.right,key) + size(x.left) + 1;
        else
            return size(x.left);
    }

    public void deleteMin(){
        root = deleteMin(root);
    }

    private Node deleteMin(Node x){
        if(x.left == null)
            return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key){
        root = delete(root,key);
    }

    private Node delete(Node x,Key key){
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0)
            x.left = delete(x.left,key);
        else if(cmp > 0)
            x.right = delete(x.right,key);
        else {
            if(x.right == null)
                return x.left;
            if(x.left == null)
                return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Iterable<Key> keys(){
        return keys(min(),max());
    }

    public Iterable<Key> keys(Key lo,Key hi){
        LinkedList<Key> list = new LinkedList<>();
        keys(root,list,lo,hi);
        return list;
    }

    public void keys(Node x, LinkedList<Key> list,Key lo,Key hi){
        if(x == null)
            return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if(cmplo < 0)
            keys(x.left,list,lo,hi);
        if(cmplo <= 0 && cmphi >= 0)
            list.add(x.key);
        if(cmphi > 0)
            keys(x.right,list,lo,hi);
    }
}
