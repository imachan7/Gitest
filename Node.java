import java.util.ArrayList;


class Node{
    private int id;
    ArrayList<Edge> edges;
    Node(int id){
        this.id = id;
        edges = new ArrayList<Edge>();
    }
    public int getId(){
        return id;
    }
    public void addEdge(Edge e){
        edges.add(e);
    }
    ArrayList<Edge> getList(){return edges;};

}
