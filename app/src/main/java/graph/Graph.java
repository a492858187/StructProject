package graph;

import java.util.Iterator;

public class Graph {

    private final int V;    //顶点数目
    private int E;  //边的数目
    private Bag<Integer>[] adj; //邻接表

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[])new Bag[V];
        for (int v = 0;v < V;v++){
            adj[v] = new Bag<Integer>();
        }
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public void addEdge(int v,int w){
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public String toString(){
        String s = V + " vertices, " + E + " edges\n";
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        for (int v=0;v<V;v++){
            sb.append(v).append(":");
            /*Iterator iterator = this.adj(v).iterator();
            while (iterator.hasNext()){
                sb.append(iterator.next()).append(" ");
            }*/
            for (int w:this.adj(v))
                sb.append(w).append(" ");
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Graph graph = new Graph(13);
        graph.addEdge(0,5);
        graph.addEdge(4,3);
        graph.addEdge(0,1);
        graph.addEdge(9,12);
        graph.addEdge(6,4);
        graph.addEdge(5,4);
        graph.addEdge(0,2);
        graph.addEdge(11,12);
        graph.addEdge(9,10);
        graph.addEdge(0,6);
        graph.addEdge(7,8);
        graph.addEdge(9,11);
        graph.addEdge(5,3);

        System.out.println(graph.toString());
        System.out.println("0的度为：" + GraphUtil.degree(graph,0));
        System.out.println("最大的度为：" + GraphUtil.maxDegree(graph));
        System.out.println("平均的度为：" + GraphUtil.avgDegree(graph));
        System.out.println("自环为：" + GraphUtil.numberOfSelfLoops(graph));
    }
}
