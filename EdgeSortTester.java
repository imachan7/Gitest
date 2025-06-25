// 課題2: 辺のソート EdgeSortTester.java
/**
 * EdgeSortTester
 */
public class EdgeSortTester {

    public static void main(String[] args) {
        WUGraph kadai2 = new WUGraph(args[0]);
        System.out.println("ソート前");
        for(Edge e: kadai2.getEdges()){
            System.out.println(e.getNum()+":"+e.getFrom()+","+e.getTo() + "," +  e.getCost());
        }
        System.out.println("ソート後");
        for(Edge e: kadai2.getSortEdges()){
            System.out.println(e.getNum()+":"+e.getFrom()+","+e.getTo() + "," +  e.getCost());
        }
    }
}