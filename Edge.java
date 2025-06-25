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
