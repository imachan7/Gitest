// 課題4: クラスカル法 MSTTester.java
class MSTTester{
    public static void main(String[] args){
        System.out.println("クラスカル法スタート");
        WUGraph kadai4 = new WUGraph(args[0]);
        WUGraph MstGraph = kadai4.getMST();
        System.out.println("TotalWeight: "+MstGraph.getSumCost());
        System.out.println("MST:");
        MstGraph.printGraph();
        


        
    }
}