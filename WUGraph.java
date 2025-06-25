// 課題1～4: 重み付き無向グラフのクラス WUGraph.java
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

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
class Edge implements Comparable<Edge>{
    private int num;
    private int cost;
    private int from;
    private int to;
    Edge(int num,int cost,int from,int to){
        this.num = num;
        this.cost = cost;
        this.from = from;
        this.to = to;
    }
    public int getNum(){return num;}
    public int getCost(){return cost;}
    public int getFrom(){return from;}
    public int getTo(){return to;}
    
    @Override
    public int compareTo(Edge e){
        if(this.cost > e.getCost()){
            return 1;
        }else if(this.cost < e.getCost()){
            return -1;
        }else{ return 1;}
    }

}

public class WUGraph{
    private ArrayList<Node> nodes;
    private ArrayList<Edge> edges;  
    int numOFNodes;
    int numOFEdges;
    WUGraph(String filename){
        nodes = new ArrayList<Node>();
        edges = new ArrayList<Edge>();
        loadGraph(filename);
    }

    private WUGraph(WUGraph g){//最小全域木を作るためのコンストラクタ
        nodes = new ArrayList<Node>();
        edges = new ArrayList<Edge>();
        numOFNodes = g.numOFNodes;
        numOFEdges = 0;
    }

    void loadGraph(String filename){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            line = reader.readLine();
            String [] num = line.split(",");
            numOFNodes = Integer.parseInt(num[0]);
            numOFEdges = Integer.parseInt(num[1]);
            for(int i = 0; i < numOFNodes; i++){
                nodes.add(new Node(i));
            }

            while((line = reader.readLine()) != null){
                String [] sp1 = line.split(":");
                int id = Integer.parseInt(sp1[0]);
                String [] sp2 = sp1[1].split(",");
                int from = Integer.parseInt(sp2[0]);
                int to   = Integer.parseInt(sp2[1]);
                int cost = Integer.parseInt(sp2[2]);
                Edge e = new Edge(id,cost,from,to);
                nodes.get(from).addEdge(e);
                edges.add(e);
            }  
            reader.close();
        }catch(FileNotFoundException e){
            System.out.println("ファイルが見つかりません");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    void printGraph(){
        System.out.println(numOFNodes+","+numOFEdges);
        for(Edge e:edges){
            System.out.println(e.getNum()+":"+e.getFrom()+","+e.getTo() + "," +  e.getCost());//
        }

    }

    ArrayList<Edge> getEdges(){
        return edges;
    }

    ArrayList<Edge> getSortEdges(){
        ArrayList<Edge> al = new ArrayList<>(edges);
        Collections.sort(al);
        return al;
    }

    WUGraph getMST(){
        WUGraph mst = new WUGraph(this);
        ArrayList<Edge> selst = getSortEdges();
        UnionFind uf = new UnionFind(nodes.size());
        for(Edge e: selst){
            if(uf.unite(e.getFrom(),e.getTo())){
                mst.edges.add(e);
                mst.numOFEdges++;
            }
        }
        return mst;
    }

    int getSumCost(){
        int sum = 0;
        for(Edge e: edges){
            sum += e.getCost();
        }
        return sum;
    }
}