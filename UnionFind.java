// 課題3: union-findデータ構造 UnionFind.java
class UnionFind {
    private int[] parent;
    private int[] rank;
    UnionFind(int n){
        parent = new int[n];
        rank   = new int[n];
        for(int i = 0;i < n; i++){
            parent[i] = i;
            rank[i]   = 0;
        } 
    }

    int find(int x){
        int parentId = this.parent[x];
        while (!(parentId == this.parent[parentId])) {
            parentId = this.parent[parentId];
        }
        return parentId;
    }

    boolean unite(int x, int y){
        int rx = find(x);
        int ry = find(y);
        if(rx == ry){return false;}//親が同じなのでfalse

        if(rank[rx] < rank[ry]){//ryの方が大きいのでrxをryの子にする
            parent[rx] = ry;
        }else{//rxの方がry以上の大きさなのでryをrxの子にする
            parent[ry] = rx;
            if(rank[rx] == rank[ry]){rank[rx]++;}//大きさが同じときrxの大きさを更新　rxに対して同じ大きさの木をつなげるので+1だけでよい
        }
        return true;

        

    }
}