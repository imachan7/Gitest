// 課題3: union-findデータ構造 UnionFindTester.java
class UnionFindTester{
    public static void main(String[] args) {
        UnionFind kadai3_0 = new UnionFind(10);
        System.out.println("0を親1を子としてつなげる");
        kadai3_0.unite(0,1);
        System.out.println("0を親3を子としてつなげる");
        kadai3_0.unite(0,3);
        System.out.println("3の根は"+kadai3_0.find(3));

        UnionFind kadai3_1 = new UnionFind(10); 
        System.out.println("2を親4を子としてつなげる");
        kadai3_1.unite(2,4);
        System.out.println("4を親6を子としてつなげる");
        kadai3_1.unite(4,6);
        System.out.println("6の根は"+kadai3_1.find(6));



        // テストパターン5
        UnionFind kadai3_2 = new UnionFind(10);
        System.out.println("4を親9を子としてつなげる");
        kadai3_2.unite(4,9);
        System.out.println("9を親0を子としてつなげられるか" + kadai3_2.unite(9,0));
        System.out.println("0と4はつなげられるか" + kadai3_2.unite(0,4));
        System.out.println("0の根は" + kadai3_2.find(0));
    }
}